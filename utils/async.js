const fetch = require('node-fetch') || window.fetch

/**
 * Получает JSON по GET-запросу к определённому URL
 * @param {String} url 
 * @return {Promise}
 */
const getJson = url => fetch(url).then(response => response.json())

module.exports = {
  getJson
}