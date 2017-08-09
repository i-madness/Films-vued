const { filter, reduce, isSorted, reverse, isPalindrome, isBalanced, uniq, intersect } = require('../collections')

test('[filter]\t Отбор элементов массива, соответствующих предикату', () => {
  expect(filter([1, 3, 4], el => el > 1)).toContain(3, 4)
  expect(filter([{ a: 'b' }, { b: 'c' }, 4], el => typeof el !== 'number'))
})

test('[reduce]\t Сводит массив к определённому значению на основании коллбэка', () => {
  expect(reduce([1, 3, 4], (prev, next) => prev + next, 0)).toBe(8)
  expect(reduce(["my", "name", "is", "Alice"], (prev, next) => prev.concat(next), "")).toBe("mynameisAlice")
  expect(reduce(["abc", "def", "ghi"], (prev, next) => prev.concat(next), [])).toContain("abc", "def", "ghi")
})

test('[isSorted]\t Проверяет, отсортирован ли числовой массив', () => {
  expect(isSorted([1, 3, 4])).toBeTruthy()
  expect(isSorted([0, 0, 1, 1, 2, 3, 4,])).toBeTruthy()
  expect(isSorted([1, 0, 4, 2])).toBeFalsy()
})

test('[reverse]\t "Разворачивает" массив или строку', () => {
  expect(reverse([1, 3, 4]).join(",")).toBe('4,3,1')
  expect(reverse('quaff')).toBe('ffauq')
})

test('[isPalindrome] Проверяет, является ли строка палиндромом', () => {
  expect(isPalindrome('abba')).toBeTruthy()
  expect(isPalindrome('wut')).toBeFalsy()
})

test('[isBalanced] Проверяет, сбалансированны ли скобки в строке', () => {
  //expect(isBalanced('{{}}')).toBeTruthy()
  //expect(isBalanced('{{}')).toBeFalsy()
})

test('[uniq]\t Возвращает массив с неповторяющимися элементами из исходного', () => {
  expect(uniq([1, 2, 2, 4, 4, 4]).join(',')).toBe('1,2,4')
  let obj1 = {}, obj2 = { prop: 'value' }
  expect(uniq([obj1, obj2, obj2, obj1]).length).toBe(2)
})

test('[intersect]\t Возвращает пересечение двух массивов', () => {
  expect(intersect([3, 4, 5, 5, 6], [4, 5, 5]).join(',')).toBe('4,5')
})
