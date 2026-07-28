import { useEffect, useRef } from 'react';
import type { WikiSkillSourceAnimationEvent } from '@/types';

type PixelSurface = {
    pixels: Uint8ClampedArray;
    width: number;
    height: number;
    offsetX: number;
    offsetY: number;
};

type ProceduralEffectCanvasProps = {
    artworkUrl: string;
    fallbackArtworkUrl: string;
    originX: number;
    originY: number;
    direction: 0 | 1;
    event: WikiSkillSourceAnimationEvent;
    playbackKey: string;
    className?: string;
};

const TRANSPARENT_MARKER = [255, 255, 255, 0] as const;
const CANVAS_MARGIN = 96;

export function LietHoaProceduralEffectCanvas({
    artworkUrl,
    fallbackArtworkUrl,
    originX,
    originY,
    direction,
    event,
    playbackKey,
    className,
}: ProceduralEffectCanvasProps) {
    const canvasRef = useRef<HTMLCanvasElement>(null);

    useEffect(() => {
        const canvas = canvasRef.current;
        const parameters = event.source_parameters;

        if (
            canvas === null ||
            event.runtime_renderer !== 'a.a.b.canvas.v1' ||
            parameters === undefined
        ) {
            return;
        }

        let isCancelled = false;
        let timer: number | undefined;

        void loadRendererInputs(
            artworkUrl,
            fallbackArtworkUrl,
            event.texture_url,
        ).then(({ artwork, texture }) => {
            if (isCancelled) {
                return;
            }

            const base = surfaceFromImage(
                artwork,
                direction === 1,
                true,
                originX,
                originY,
            );
            const renderer = createRenderer(
                parameters,
                base,
                texture,
                direction,
            );
            const context = canvas.getContext('2d');

            if (context === null) {
                return;
            }

            canvas.width = base.width + CANVAS_MARGIN * 2;
            canvas.height = base.height + CANVAS_MARGIN * 2;
            const baseSize = Math.max(base.width, base.height);
            canvas.style.width = `${(canvas.width / baseSize) * 100}%`;
            canvas.style.height = `${(canvas.height / baseSize) * 100}%`;
            context.imageSmoothingEnabled = false;

            const drawFrame = () => {
                context.clearRect(0, 0, canvas.width, canvas.height);
                renderer.draw(context, CANVAS_MARGIN, CANVAS_MARGIN);
                renderer.advance();
            };

            drawFrame();
            timer = window.setInterval(drawFrame, event.tick_ms ?? 66);
        });

        return () => {
            isCancelled = true;

            if (timer !== undefined) {
                window.clearInterval(timer);
            }
        };
    }, [
        artworkUrl,
        direction,
        event,
        fallbackArtworkUrl,
        originX,
        originY,
        playbackKey,
    ]);

    return <canvas ref={canvasRef} aria-hidden="true" className={className} />;
}

async function loadRendererInputs(
    artworkUrl: string,
    fallbackArtworkUrl: string,
    textureUrl?: string,
): Promise<{ artwork: HTMLImageElement; texture: HTMLImageElement | null }> {
    const [artwork, texture] = await Promise.all([
        loadImage(artworkUrl).catch(() => loadImage(fallbackArtworkUrl)),
        textureUrl === undefined
            ? Promise.resolve(null)
            : loadImage(textureUrl),
    ]);

    return { artwork, texture };
}

function loadImage(url: string): Promise<HTMLImageElement> {
    return new Promise((resolve, reject) => {
        const image = new Image();
        image.onload = () => resolve(image);
        image.onerror = () =>
            reject(new Error(`Unable to load pixel source: ${url}`));
        image.src = url;
    });
}

function surfaceFromImage(
    image: HTMLImageElement,
    mirrorX: boolean,
    normalizeTransparency = true,
    originX = 0,
    originY = 0,
): PixelSurface {
    const canvas = document.createElement('canvas');
    canvas.width = image.naturalWidth;
    canvas.height = image.naturalHeight;
    const context = canvas.getContext('2d', { willReadFrequently: true });

    if (context === null) {
        throw new Error('Canvas 2D is unavailable');
    }

    context.imageSmoothingEnabled = false;

    if (mirrorX) {
        context.translate(canvas.width, 0);
        context.scale(-1, 1);
    }

    context.drawImage(image, 0, 0);
    const imageData = context.getImageData(0, 0, canvas.width, canvas.height);

    if (normalizeTransparency) {
        normalizeSnapshotTransparency(imageData.data);
    }

    return {
        pixels: imageData.data,
        width: canvas.width,
        height: canvas.height,
        offsetX: mirrorX ? -originX - canvas.width : originX,
        offsetY: originY,
    };
}

function normalizeSnapshotTransparency(pixels: Uint8ClampedArray): void {
    for (let index = 0; index < pixels.length; index += 4) {
        const isTransparent = pixels[index + 3] === 0;
        const isPureWhite =
            pixels[index] === 255 &&
            pixels[index + 1] === 255 &&
            pixels[index + 2] === 255;
        const isPureBlack =
            pixels[index] === 0 &&
            pixels[index + 1] === 0 &&
            pixels[index + 2] === 0;

        if (isTransparent || isPureWhite || isPureBlack) {
            setTransparentMarker(pixels, index);
        }
    }
}

function createRenderer(
    parameters: number[],
    base: PixelSurface,
    textureImage: HTMLImageElement | null,
    direction: 0 | 1,
): {
    draw: (context: CanvasRenderingContext2D, x: number, y: number) => void;
    advance: () => void;
} {
    const effectType = parameters[0];
    const texture =
        textureImage === null
            ? null
            : surfaceFromImage(textureImage, false, false);

    switch (effectType) {
        case 1:
            return textureMaskRenderer(parameters, base, texture);
        case 7:
            return scalePulseRenderer(parameters, base);
        case 8:
            return stagedScaleRenderer(parameters, base);
        case 9:
            return colorFlashRenderer(parameters, base);
        case 11:
        case 14:
            return trailRenderer(parameters, base, direction);
        case 12:
            return dualPathRenderer(parameters, base, direction);
        case 13:
            return multiPathRenderer(parameters, base, direction);
        case 15:
            return selectedTrailRenderer(parameters, base, direction);
        default:
            throw new Error(`Unsupported a.a.b renderer type: ${effectType}`);
    }
}

function textureMaskRenderer(
    parameters: number[],
    base: PixelSurface,
    texture: PixelSurface | null,
) {
    if (texture === null) {
        throw new Error('a.a.b type 1 requires its decoded texture');
    }

    const state = parameters.slice(1);
    let rendered = cloneSurface(base);

    const advance = () => {
        shiftTexture(texture, state[4]);
        rendered = combineWithTexture(base, texture, state[3]);
        state[0] += 1;
    };
    advance();

    return {
        draw: (context: CanvasRenderingContext2D, x: number, y: number) =>
            drawSurface(context, rendered, x, y),
        advance,
    };
}

function scalePulseRenderer(parameters: number[], base: PixelSurface) {
    const state = parameters.slice(1);
    const scaledWidth = Math.max(
        1,
        Math.trunc((base.width * parameters[4]) / parameters[5]),
    );
    const scaledHeight = Math.max(
        1,
        Math.trunc((base.height * parameters[6]) / parameters[7]),
    );
    const scaled = scaleNearest(base, scaledWidth, scaledHeight);
    const offsetX = Math.trunc((base.width - scaledWidth) / 2);
    const offsetY = base.height - scaledHeight;

    return {
        draw(context: CanvasRenderingContext2D, x: number, y: number) {
            if (Math.trunc(state[0] / state[2]) % 2 === 0) {
                drawSurface(context, scaled, x + offsetX, y + offsetY);
            } else {
                drawSurface(context, base, x, y);
            }
        },
        advance() {
            state[0] += 1;
        },
    };
}

function stagedScaleRenderer(parameters: number[], base: PixelSurface) {
    const state = parameters.slice(1);
    let rendered = cloneSurface(base);

    if (state[4] === 1) {
        rendered = multiplyAndOffset(scaleByTenths(rendered, state[2]), 1, 50);
        rendered.offsetX += state[3];
        rendered.offsetY += state[4];
    }

    return {
        draw: (context: CanvasRenderingContext2D, x: number, y: number) =>
            drawSurface(context, rendered, x, y),
        advance() {
            if (state[0] < Math.trunc(state[1] / state[3]) * state[2]) {
                if (state[4] === 1) {
                    rendered = cloneSurface(base);
                }

                const parameterIndex = 5 + (state[2] - 1) * 3;
                rendered = multiplyAndOffset(
                    scaleByTenths(rendered, state[parameterIndex]),
                    1,
                    50,
                );
                rendered.offsetX += state[parameterIndex + 1];
                rendered.offsetY += state[parameterIndex + 2];
            } else {
                state[2] += 1;
            }

            state[0] += 1;
        },
    };
}

function colorFlashRenderer(parameters: number[], base: PixelSurface) {
    const state = parameters.slice(5);
    const overlay = multiplyAndOffset(
        recolor(
            base,
            parameters[1],
            parameters[2],
            parameters[3],
            parameters[4],
        ),
        1,
        50,
    );

    return {
        draw(context: CanvasRenderingContext2D, x: number, y: number) {
            drawSurface(context, base, x, y);

            if (Math.trunc(state[0] / state[2]) % 2 === 0) {
                drawSurface(context, overlay, x, y);
            }
        },
        advance() {
            state[0] += 1;
        },
    };
}

function trailRenderer(
    parameters: number[],
    base: PixelSurface,
    direction: 0 | 1,
) {
    const effectType = parameters[0];
    const copyCount = parameters[1];
    const surfaces = [cloneSurface(base)];

    for (let copy = 1; copy < copyCount; copy += 1) {
        const parameterIndex = 2 + (copy - 1) * 4;
        surfaces.push(
            effectType === 11
                ? recolor(
                      base,
                      parameters[parameterIndex],
                      parameters[parameterIndex + 1],
                      parameters[parameterIndex + 2],
                      parameters[parameterIndex + 3],
                  )
                : multiplyAndOffset(
                      base,
                      parameters[parameterIndex],
                      parameters[parameterIndex + 1],
                  ),
        );
    }

    const state = parameters.slice(2 + (copyCount - 1) * 4);

    return {
        draw(context: CanvasRenderingContext2D, x: number, y: number) {
            for (let copy = 1; copy < surfaces.length; copy += 1) {
                const vector =
                    4 + state[0] * (surfaces.length - 1) * 2 + (copy - 1) * 2;
                drawSurface(
                    context,
                    surfaces[copy],
                    x + signedX(state[vector], direction),
                    y + state[vector + 1],
                );
            }
        },
        advance: cadenceAdvance(state),
    };
}

function dualPathRenderer(
    parameters: number[],
    base: PixelSurface,
    direction: 0 | 1,
) {
    const copyCount = parameters[1];
    const surfaces = Array.from({ length: copyCount }, (_, index) =>
        setAlpha(base, parameters[2 + index]),
    );
    const state = parameters.slice(2 + copyCount);

    return {
        draw(context: CanvasRenderingContext2D, x: number, y: number) {
            const firstVector = 4 + state[0] * 2;
            const secondVector = 4 + state[1] * 2 + state[0] * 2;
            drawSurface(
                context,
                surfaces[1],
                x +
                    signedX(
                        state[secondVector] + state[firstVector],
                        direction,
                    ),
                y - state[secondVector + 1] + state[firstVector + 1],
            );
            drawSurface(
                context,
                surfaces[0],
                x + signedX(state[firstVector], direction),
                y + state[firstVector + 1],
            );
        },
        advance: cadenceAdvance(state),
    };
}

function multiPathRenderer(
    parameters: number[],
    base: PixelSurface,
    direction: 0 | 1,
) {
    const copyCount = parameters[1];
    const surfaces = Array.from({ length: copyCount }, (_, index) =>
        setAlpha(base, parameters[2 + index]),
    );
    const state = parameters.slice(2 + copyCount);

    return {
        draw(context: CanvasRenderingContext2D, x: number, y: number) {
            surfaces.forEach((surface, copy) => {
                const vector = 4 + state[0] * surfaces.length * 2 + copy * 2;
                drawSurface(
                    context,
                    surface,
                    x + signedX(state[vector], direction),
                    y + state[vector + 1],
                );
            });
        },
        advance: cadenceAdvance(state),
    };
}

function selectedTrailRenderer(
    parameters: number[],
    base: PixelSurface,
    direction: 0 | 1,
) {
    const copyCount = parameters[1];
    const surfaces = [cloneSurface(base)];

    for (let copy = 1; copy < copyCount; copy += 1) {
        const parameterIndex = 2 + (copy - 1) * 4;
        surfaces.push(
            recolor(
                base,
                parameters[parameterIndex],
                parameters[parameterIndex + 1],
                parameters[parameterIndex + 2],
                parameters[parameterIndex + 3],
            ),
        );
    }

    const state = parameters.slice(2 + (copyCount - 1) * 4);

    return {
        draw(context: CanvasRenderingContext2D, x: number, y: number) {
            const vector = 4 + state[0] * 3;
            const surface = surfaces[state[vector]];

            if (surface !== undefined) {
                drawSurface(
                    context,
                    surface,
                    x + signedX(state[vector + 1], direction),
                    y + state[vector + 2],
                );
            }
        },
        advance: cadenceAdvance(state),
    };
}

function cadenceAdvance(state: number[]): () => void {
    return () => {
        if (state[2] < state[3]) {
            state[2] += 1;
        } else {
            state[2] = 0;
            state[0] += 1;

            if (state[0] >= state[1]) {
                state[0] = 0;
            }
        }
    };
}

function signedX(value: number, direction: 0 | 1): number {
    return direction === 1 ? -value : value;
}

function cloneSurface(surface: PixelSurface): PixelSurface {
    return { ...surface, pixels: new Uint8ClampedArray(surface.pixels) };
}

function scaleByTenths(surface: PixelSurface, scale: number): PixelSurface {
    return scaleNearest(
        surface,
        Math.max(1, Math.trunc((surface.width * scale) / 10)),
        Math.max(1, Math.trunc((surface.height * scale) / 10)),
        scale,
    );
}

function scaleNearest(
    surface: PixelSurface,
    width: number,
    height: number,
    offsetScale?: number,
): PixelSurface {
    const pixels = new Uint8ClampedArray(width * height * 4);

    for (let y = 0; y < height; y += 1) {
        for (let x = 0; x < width; x += 1) {
            const sourceX = Math.trunc((x * surface.width) / width);
            const sourceY = Math.trunc((y * surface.height) / height);
            const sourceIndex = (sourceY * surface.width + sourceX) * 4;
            const targetIndex = (y * width + x) * 4;
            pixels.set(
                surface.pixels.subarray(sourceIndex, sourceIndex + 4),
                targetIndex,
            );
        }
    }

    return {
        pixels,
        width,
        height,
        offsetX:
            offsetScale === undefined
                ? surface.offsetX
                : Math.trunc((surface.offsetX * offsetScale) / 10),
        offsetY:
            offsetScale === undefined
                ? surface.offsetY
                : Math.trunc((surface.offsetY * offsetScale) / 10),
    };
}

function multiplyAndOffset(
    source: PixelSurface,
    multiplier: number,
    offset: number,
): PixelSurface {
    const surface = cloneSurface(source);

    for (let index = 0; index < surface.pixels.length; index += 4) {
        surface.pixels[index] = clampByte(
            surface.pixels[index] * multiplier + offset,
        );
        surface.pixels[index + 1] = clampByte(
            surface.pixels[index + 1] * multiplier + offset,
        );
        surface.pixels[index + 2] = clampByte(
            surface.pixels[index + 2] * multiplier + offset,
        );
    }

    return surface;
}

function setAlpha(source: PixelSurface, alpha: number): PixelSurface {
    const surface = cloneSurface(source);

    if (alpha < 0 || alpha > 255) {
        return surface;
    }

    for (let index = 0; index < surface.pixels.length; index += 4) {
        if (!isTransparentMarker(surface.pixels, index)) {
            surface.pixels[index + 3] = alpha;
        }
    }

    return surface;
}

function recolor(
    source: PixelSurface,
    alpha: number,
    red: number,
    green: number,
    blue: number,
): PixelSurface {
    const surface = cloneSurface(source);

    for (let index = 0; index < surface.pixels.length; index += 4) {
        if (isTransparentMarker(surface.pixels, index)) {
            continue;
        }

        surface.pixels[index] = red;
        surface.pixels[index + 1] = green;
        surface.pixels[index + 2] = blue;
        surface.pixels[index + 3] = alpha >= 0 && alpha <= 255 ? alpha : 0;
    }

    return surface;
}

function combineWithTexture(
    source: PixelSurface,
    texture: PixelSurface,
    mode: number,
): PixelSurface {
    const surface =
        mode === 0 ? multiplyAndOffset(source, 5, 5) : cloneSurface(source);

    for (let y = 0; y < surface.height; y += 1) {
        for (let x = 0; x < surface.width; x += 1) {
            const index = (y * surface.width + x) * 4;

            if (surface.pixels[index + 3] === 0) {
                continue;
            }

            const textureIndex =
                ((y % texture.height) * texture.width + (x % texture.width)) *
                4;

            for (let channel = 0; channel < 4; channel += 1) {
                if (mode === 0) {
                    surface.pixels[index + channel] &=
                        texture.pixels[textureIndex + channel];
                } else if (mode === 1) {
                    surface.pixels[index + channel] |=
                        texture.pixels[textureIndex + channel];
                } else if (mode === 2) {
                    surface.pixels[index + channel] =
                        texture.pixels[textureIndex + channel];
                }
            }
        }
    }

    return surface;
}

function shiftTexture(texture: PixelSurface, direction: number): void {
    const pixels = texture.pixels;
    const width = texture.width;
    const height = texture.height;
    const shift = Math.min(4, direction < 2 ? height : width);
    const original = new Uint8ClampedArray(pixels);

    for (let y = 0; y < height; y += 1) {
        for (let x = 0; x < width; x += 1) {
            let sourceX = x;
            let sourceY = y;

            if (direction === 0) {
                sourceY = (y + shift) % height;
            } else if (direction === 1) {
                sourceY = (y - shift + height) % height;
            } else if (direction === 2) {
                sourceX = (x + shift) % width;
            } else if (direction === 3) {
                sourceX = (x - shift + width) % width;
            }

            const targetIndex = (y * width + x) * 4;
            const sourceIndex = (sourceY * width + sourceX) * 4;
            pixels.set(
                original.subarray(sourceIndex, sourceIndex + 4),
                targetIndex,
            );
        }
    }
}

function drawSurface(
    context: CanvasRenderingContext2D,
    surface: PixelSurface,
    x: number,
    y: number,
): void {
    const layer = document.createElement('canvas');
    layer.width = surface.width;
    layer.height = surface.height;
    const layerContext = layer.getContext('2d');

    if (layerContext === null) {
        return;
    }

    layerContext.putImageData(
        new ImageData(
            new Uint8ClampedArray(surface.pixels),
            surface.width,
            surface.height,
        ),
        0,
        0,
    );
    context.drawImage(layer, x + surface.offsetX, y + surface.offsetY);
}

function isTransparentMarker(
    pixels: Uint8ClampedArray,
    index: number,
): boolean {
    return (
        pixels[index] === TRANSPARENT_MARKER[0] &&
        pixels[index + 1] === TRANSPARENT_MARKER[1] &&
        pixels[index + 2] === TRANSPARENT_MARKER[2] &&
        pixels[index + 3] === TRANSPARENT_MARKER[3]
    );
}

function setTransparentMarker(pixels: Uint8ClampedArray, index: number): void {
    pixels[index] = TRANSPARENT_MARKER[0];
    pixels[index + 1] = TRANSPARENT_MARKER[1];
    pixels[index + 2] = TRANSPARENT_MARKER[2];
    pixels[index + 3] = TRANSPARENT_MARKER[3];
}

function clampByte(value: number): number {
    return Math.max(0, Math.min(255, value));
}
