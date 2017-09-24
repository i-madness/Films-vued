io = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

logAndInput = (text, callback) -> io.question("#{text}", callback)

Console = 
  startGame: () -> 
    logAndInput 'So your adventure begins... How is your name by the way?\n', (answer) -> console.log "Ah, hello there #{answer}"

module.exports = Console