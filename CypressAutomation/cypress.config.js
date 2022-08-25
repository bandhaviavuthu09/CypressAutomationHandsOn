const { defineConfig } = require("cypress");
const cucumber = require('cypress-cucumber-preprocessor').default

module.exports = defineConfig({
  chromeWebSecurity: false,
  defaultCommandTimeout: 8000,
  pageLoadTimeout: 30000,
  reporter: 'mochawesome',

  env: {
    url: 'https://rahulshettyacademy.com'
  },
  retries: {
    runMode: 1,
  },
  projectId: 'ovtzeh',

  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
      //return require('./cypress/plugins/index.js')(on, config)
        on('file:preprocessor', cucumber())
      },
    specPattern: 'cypress/Integration/examples/BDD/*.feature'
  },
});
