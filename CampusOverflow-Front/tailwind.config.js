/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        background: '#f1f2f3',
        facebook: '#3b5998',
        github: '#333',
      }
    },
  },
  plugins: [],
}
