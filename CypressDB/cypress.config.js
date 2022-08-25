const { defineConfig } = require("cypress");

module.exports = defineConfig({
  defaultCommandTimeout: 8000,
  pageLoadTimeout: 30000,

  db: {
    userName: 'rsa',
    password: 'bangalore5G*',
    server: 'dbcyp.database.windows.net',
    options: {
        database: 'CypressDBIntegration',
        encrypt: true,
        rowCollectionOnRequestCompletion : true
    }
  },

  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
    specPattern: 'cypress/Integration/example/*.js'
  },
});
