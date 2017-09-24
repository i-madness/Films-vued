require 'coffeescript/register'
io = require './console'
charFactory = require './character'
character = charFactory()

character.additem "pechenko"
character.additem "chocolate"

io.startGame()