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
  if (num === 2 || num === 3) {
    return true
  } 
  if (num === 1) {
    return false
  }
  for (let div = 2; div <= Math.sqrt(num); div++) {
    if (num % div === 0) {
      return false
    }
  }
  return true
})

/**
 * Фозвращает факториал числа
 * @param {Number} num 
 */
const factorial = num => numCheck(num, (number) => {
  let base = 1
  for (let i = 1; i <= num; i++) {
    base *= i
  }
  return base
})

module.exports = {
  isPrime,
  factorial
}