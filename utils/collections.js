/**
 * Фильтрует элементы указанного массива. Аналог Array.prototype.filter
 * @param {Array} array 
 * @param {Function} predicate 
 */
const filter = (array, predicate) => {
  let result = []
  for (element of array) {
    if (predicate(element)) {
      result.push(element)
    }
  }
  return result
}

/**
 * Сводит массив к определённому значению, применяя заданную функцию
 * к элементам массива проходом от начала и до конца
 * @param {Array} array 
 * @param {Function} callback 
 * @param {any} initial 
 */
const reduce = (array, callback, initial) => {
  for (let el of array) {
    initial = callback(initial, el)
  }
  return initial
}

/**
 * Проверяет, отсортирован ли числовой массив
 * @param {Array<Number>} array 
 */
const isSorted = array => {
  if (!array.length) {
    return true
  }
  for (let i = 0; i < array.length; i++) {
    let currentElement = array[i]
    let nextElement = array[i + 1]
    if (nextElement && currentElement > nextElement) {
      return false
    }
  }
  return true
}

/**
 * Возвращает массив с обратным порядком следования элементов по отношению к заданном массиву
 * @param {Array|String} array 
 */
const reverse = array => {
  let reverseOrder = []
  let length = array.length
  for (let i = length - 1; i >= 0; i--) {
    reverseOrder.push(array[i])
  }
  if (typeof array === 'string') {
    return reverseOrder.join('')
  }
  return reverseOrder
}

module.exports = {
  filter,
  reduce,
  isSorted,
  reverse
}