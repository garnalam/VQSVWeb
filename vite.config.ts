import inertia from '@inertiajs/vite';
import { wayfinder } from '@laravel/vite-plugin-wayfinder';
import tailwindcss from '@tailwindcss/vite';
import react from '@vitejs/plugin-react';
import laravel from 'laravel-vite-plugin';
import { bunny } from 'laravel-vite-plugin/fonts';
import { defineConfig } from 'vite';

export default defineConfig(({ command }) => {
    // Kiểm tra xem Vite đang chạy lệnh `dev` (serve) hay `build`
    const isDev = command === 'serve';

    return {
        plugins: [
            laravel({
                input: ['resources/css/app.css', 'resources/js/app.tsx'],
                refresh: true,
                fonts: [
                    bunny('Instrument Sans', {
                        weights: [400, 500, 600],
                    }),
                ],
            }),
            inertia(),
            react({
                babel: {
                    plugins: ['babel-plugin-react-compiler'],
                },
            }),
            tailwindcss(),
            // Chỉ chạy Wayfinder ở môi trường dev để tránh gọi lệnh PHP khi Vercel build
            isDev && wayfinder({
                formVariants: true,
            }),
        ].filter(Boolean), // Lọc bỏ các giá trị false/undefined trong mảng plugins
    };
});