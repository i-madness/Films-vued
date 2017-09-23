require 'coffeescript/register'
require './console'
charFactory = require './character'
character = charFactory()


character.additem "pechenko"
character.additem "chocolate"

console.log character.name, character.bag