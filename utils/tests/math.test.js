const { isPrime, factorial, fibbonacci } = require('../math')

test('[isPrime]\t Проверка, является ли число простым', () => {
  expect(isPrime(1)).toBeFalsy()
  expect(isPrime(2)).toBeTruthy()
})

test('[factorial]\t Вычисление факториала числа', () => {
  expect(factorial(0)).toBe(1)
  for (let i = 1; i < 10; i++) {
    expect(factorial(i) / factorial(i - 1)).toBe(i)
  }
})

test('[fibonacci]\t Получение числа Фиббоначчи по его номеру в последовательности', () => {
  for (let i = -1; i < 2; i++) {
    expect(fibbonacci(i)).toBe(1)
  }
  for (let i = 3; i < 10; i++) {
    let fibNumber = fibbonacci(i)
    let prev = fibbonacci(i - 1)
    let prevPrev = fibbonacci(i - 2)
    expect(prevPrev + prev).toBe(fibNumber)
  }
})