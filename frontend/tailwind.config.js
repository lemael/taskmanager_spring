/** @type {import('tailwindcss').Config} */
export default {
  content: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
  theme: {
    extend: {
      colors: {
        brand: {
          500: '#3b5bdb', // Couleur d'accentuation des boutons / menus actifs
          600: '#324ec2',
        },
        dark: {
          900: '#111827', // En-tête et haut du menu
        },
      },
      fontFamily: {
        sans: ['Inter', 'sans-serif'],
      },
    },
  },
  plugins: [],
};