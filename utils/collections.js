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

/**
 * Проверяет, является ли строка палиндромом
 * @param {String} string 
 */
const isPalindrome = string => {
  if (!string) {
    return false
  }
  let reversed = reverse(string)
  return string === reversed
}

/**
 * На основе входного массива чисел 1...N возвращает число, отсутствующее в последовательности
 * @param {Array<Number>} array 
 */
const missing = array => {
  let length = array.length
  for (let i = 0; i < length; i++) {
    let prev = array[i - 1],
      current = array[i - 1]
    if (prev && current - prev !== 1) {

    }
  }
}

/**
 * 
 * @param {String} string 
 */
const isBalanced = string => {
  let openCount = 0,
    closeCount = 0,
    length = string.length
  for (let i = 0; i < length; i++) {
    if (string[i] === '{') {
      openCount++
    } else if (string[i] === '}') {
      closeCount++
    }
  }
  return openCount === closeCount
}

/**
 * Возвращает массив из уникальных, не повторяющихся элементов исходного массива
 * @param {Array} array 
 */
const uniq = array => Array.from(new Set(array))

/**
 * Возвращает пересечение двух массивов
 * @param {Array} arr1
 * @param {Array} arr2
 */
const intersect = (arr1, arr2) => {
  let len1 = arr1.length,
    len2 = arr2.length,
    intersLen = 0,
    intersection = []
  for (let i = 0; i < len1; i++) {
    let j = 0, k = 0
    while (arr2[j] !== arr1[i] && j < len2)
      j++
    while (intersection[k] !== arr1[i] && k < intersLen)
      k++
    if (j != len2 && k == intersLen) {
      intersection[intersLen++] = arr1[i]
    }
  }
  return intersection;
}

module.exports = {
  filter,
  reduce,
  isSorted,
  reverse,
  isPalindrome,
  isBalanced,
  uniq,
  intersect
}