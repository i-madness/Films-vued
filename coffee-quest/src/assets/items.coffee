itemTypes = {
  food: 'food',
  valuable: 'valuable'
}

items = () => [
  { name: 'coffee', type: itemTypes.food, value: 10 }
  { name: 'sandwich', type: itemTypes.food, value: 4 }
  { name: 'coin', type: itemTypes.valuable, value: 1 }
]

module.exports = items