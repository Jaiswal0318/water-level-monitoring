module.exports = {
  root: true,
  env: {
    node: true,
    es2021: true,
  },
  extends: [
    "eslint:recommended",
  ],
  ignorePatterns: [
    "node_modules/",
    "lib/",
    "dist/",
  ],
  rules: {
    "no-unused-vars": "off",  // turn off unused vars error
  },
};
