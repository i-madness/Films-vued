itemTypes = {
  food: 'food',
  valuable: 'valuable'
}

items = () => [
  { name: 'espresso', type: itemTypes.food, value: 3 },
  { name: 'americano', type: itemTypes.food, value: 4 },
  { name: 'latte', type: itemTypes.food, value: 5 },
  { name: 'mocha', type: itemTypes.food, value: 6 },
  { name: 'coin', type: itemTypes.valuable, value: 1 },
  { name: 'gem', type: itemTypes.valuable, value: 30 }
]

module.exports = items