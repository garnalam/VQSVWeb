#!/usr/bin/env python3
"""Regression tests for the Rainbow sprite renderer."""

from __future__ import annotations

import unittest
from pathlib import Path
from tempfile import TemporaryDirectory
from unittest.mock import patch

from PIL import Image

from extract_rainbow_assets import (
    GAME_TRANSFORM_TO_J2ME,
    SpriteData,
    animation_frames,
    render_effects,
    scale_animation_frames,
    transform_region,
)


class TransformRegionTest(unittest.TestCase):
    def setUp(self) -> None:
        self.region = Image.new("L", (2, 3))
        self.region.putdata((1, 2, 3, 4, 5, 6))

    def test_game_transform_table_matches_decompiled_renderer(self) -> None:
        self.assertEqual(GAME_TRANSFORM_TO_J2ME, (0, 5, 3, 6, 2, 4, 1, 7))

    def test_compact_transform_indexes_are_applied_before_j2me_transforms(self) -> None:
        expected_pixels = {
            0: ((2, 3), (1, 2, 3, 4, 5, 6)),
            1: ((3, 2), (5, 3, 1, 6, 4, 2)),
            2: ((2, 3), (6, 5, 4, 3, 2, 1)),
            3: ((3, 2), (2, 4, 6, 1, 3, 5)),
            4: ((2, 3), (2, 1, 4, 3, 6, 5)),
            5: ((3, 2), (6, 4, 2, 5, 3, 1)),
            6: ((2, 3), (5, 6, 3, 4, 1, 2)),
            7: ((3, 2), (1, 3, 5, 2, 4, 6)),
        }

        for transform, (size, pixels) in expected_pixels.items():
            with self.subTest(transform=transform):
                transformed = transform_region(self.region, transform)
                self.assertEqual(transformed.size, size)
                self.assertEqual(tuple(transformed.getdata()), pixels)

    def test_invalid_transform_is_rejected(self) -> None:
        with self.assertRaisesRegex(ValueError, "Invalid sprite transform"):
            transform_region(self.region, 8)


class RenderEffectsTest(unittest.TestCase):
    def test_status_effects_use_the_original_brow_icons(self) -> None:
        data = {
            "effects": [
                {"source_table": 10, "game_id": 3},
                {"source_table": 11, "game_id": 3},
                {"source_table": 11, "game_id": 6},
            ],
        }

        with TemporaryDirectory() as temporary_directory:
            public_root = Path(temporary_directory)
            with patch("extract_rainbow_assets.PUBLIC_ROOT", public_root):
                render_effects(data)

            effect_root = public_root / "effects"
            self.assertFalse((effect_root / "status-10.png").exists())
            for status_id in (3, 6):
                output_path = effect_root / f"status-{status_id}.png"
                self.assertTrue(output_path.exists())
                with Image.open(output_path) as icon:
                    self.assertEqual(icon.mode, "RGBA")
                    self.assertIsNotNone(icon.getbbox())
                    self.assertEqual(max(icon.size), 96)


class PetAnimationTest(unittest.TestCase):
    def test_attack_frames_keep_a_shared_canvas_and_original_tick_duration(self) -> None:
        atlas = Image.new("RGBA", (4, 2), (0, 0, 0, 0))
        atlas.putpixel((0, 0), (255, 0, 0, 255))
        atlas.putpixel((1, 0), (0, 255, 0, 255))
        sprite = SpriteData(
            regions=[[0, 0, 1, 1], [1, 0, 1, 1]],
            compositions=[[[0, -1, 0, 0]], [[1, 2, -1, 0]]],
            animations=[[[0, 1], [1, 3]]],
        )

        frames, durations = animation_frames(atlas, sprite, 0)

        self.assertEqual([frame.size for frame in frames], [(4, 2), (4, 2)])
        self.assertEqual(durations, [120, 240])
        self.assertEqual(frames[0].getpixel((0, 1)), (255, 0, 0, 255))
        self.assertEqual(frames[1].getpixel((3, 0)), (0, 255, 0, 255))

    def test_animation_scaling_preserves_the_shared_frame_size(self) -> None:
        frames = [Image.new("RGBA", (2, 4)), Image.new("RGBA", (2, 4))]

        scaled = scale_animation_frames(frames, 8)

        self.assertEqual([frame.size for frame in scaled], [(4, 8), (4, 8)])


if __name__ == "__main__":
    unittest.main()
