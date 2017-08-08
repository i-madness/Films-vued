/**
 * Декоратор для валидации аргумента функции. Если переданный аргумент - не число, выбрасывается ошибка 
 * @param {Object} arg 
 * @param {Function} func 
 */
const numCheck = (arg, func) => {
  if ('number' !== typeof arg) {
    throw new TypeError('Введённый аргумент не является числом')
  }
  return func(arg)
}

/**
 * Определяет, является ли число простым
 * @param {Number} num 
 */
const isPrime = num => numCheck(num, (number) => {
  if (number === 2 || number === 3) {
    return true
  }
  if (number === 1) {
    return false
  }
  for (let div = 2; div <= Math.sqrt(number); div++) {
    if (number % div === 0) {
      return false
    }
  }
  return true
})

/**
 * Фозвращает факториал числа (итеративная реализация)
 * @param {Number} num 
 */
const factorial = num => numCheck(num, (number) => {
  let base = 1
  for (let i = 1; i <= number; i++) {
    base *= i
  }
  return base
})

/**
 * Возвращает n-ный член последовательности Фибоначчи (итеративная реализация)
 * @param {Number} num 
 */
const fibbonacci = num => numCheck(num, (pos) => {
  pos = Math.floor(pos)
  let n2 = 0
  let n1 = 1
  let tmp
  for (let i = pos; i > 2; i--) {
    tmp = n2
    n2 = n1
    n1 = n1 + tmp
  }
  return n2 + n1
})

module.exports = {
  isPrime,
  factorial,
  fibbonacci
}