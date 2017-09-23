Bag = () -> 
  size: 100
  items: [ 'coffee' ]

Character = (name = 'Weary traveller') =>
  name: name
  lvl: 1
  bag: Bag()
  additem: (item) -> 
    if @bag.items.length < @bag.size
      @bag.items.push item
      return true
    else
      return false

module.exports = Character