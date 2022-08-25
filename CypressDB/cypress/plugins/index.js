

const sql = require('../../node_modules/cypress-sql-server');
const dbConfig = require('../../cypress.config')
/**
 * 
 * @type {Cypress.PluginConfig}
 */
module.exports = (on, config) => {
  tasks = sql.loadDBPlugin(dbConfig.db);
  on('task', tasks);
}