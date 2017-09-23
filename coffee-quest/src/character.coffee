character = (name = 'Weary traveller') ->
  name: name
  lvl: 1
  bag: bag()

bag = () -> 
  size: 100
  items: []
  additem: (item) => 
    if this.items.length < this.size
      this.items.push(item)
      return true
    else return false

module.exports = character