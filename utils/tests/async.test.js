const { getJson } = require('../async')

// Используем jsonplaceholder.typicode.com в качестве API
test('[getJson]\t Отправка GET-запроса на JSON-объект', () => {
  expect(
    getJson('http://jsonplaceholder.typicode.com/posts/1')
      .then(json => {
        expect(json).toBeDefined()
        expect(json).toHaveProperty('userId')
        expect(json.userId).toBe(1)
      })
  ).resolves.toHaveProperty('userId')
})