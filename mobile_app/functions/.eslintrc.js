module.exports = {
<<<<<<< HEAD
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
=======
  env: {
    es6: true,
    node: true,
  },
  parserOptions: {
    "ecmaVersion": 2018,
  },
  extends: [
    "eslint:recommended",
    "google",
  ],
  rules: {
    "no-restricted-globals": ["error", "name", "length"],
    "prefer-arrow-callback": "error",
    "quotes": ["error", "double", {"allowTemplateLiterals": true}],
  },
  overrides: [
    {
      files: ["**/*.spec.*"],
      env: {
        mocha: true,
      },
      rules: {},
    },
  ],
  globals: {},
>>>>>>> 30fef52e967bdcb7869f2953d52f3ced20dfb625
};
