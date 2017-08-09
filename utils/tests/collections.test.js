const { filter, reduce, isSorted, reverse } = require('../collections')

test('[filter]\t Отбор элементов массива, соответствующих предикату', () => {
  expect(filter([1, 3, 4], el => el > 1)).toContain(3, 4)
  expect(filter([{ a: 'b' }, { b: 'c' }, 4], el => typeof el !== 'number'))
})

test('[reduce]\t Сводит массив к определённому значению на основании коллбэка', () => {
  expect(reduce([1, 3, 4], (prev, next) => prev + next, 0)).toBe(8)
  expect(reduce(["my", "name", "is", "Alice"], (prev, next) => prev.concat(next), "mynameisAlice"))
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