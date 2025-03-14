import models.PlayingBoard

class GameEngine(
    private val playingBoard: PlayingBoard
) {
    fun init() {
        var turnCount = 0
        val maxTurns = 1000 // Safety cap

        while (turnCount++ < maxTurns) {
            println("\n==============================")

            val currentPlayer = playingBoard.players.removeLast()
            playingBoard.players.addFirst(currentPlayer)

            val diceRoll = playingBoard.dice.throwDiceOutPut()

            println("${currentPlayer.name}'s turn 🎲")
            println("Current position: ${currentPlayer.count}")
            println("Dice rolled: $diceRoll")

            val newPosition = calculateNewPosition(currentPlayer.count, diceRoll)
            if (newPosition == currentPlayer.count) {
                println("Move not possible. Need exact roll or overshoot.")
                continue
            }

            currentPlayer.count = newPosition
            println("${currentPlayer.name} moved to $newPosition")

            if (newPosition == playingBoard.size) {
                println("🏆 Winner: ${currentPlayer.name} 🎉")
                break
            }

            printCurrentPositions()
        }

        if (turnCount >= maxTurns) {
            println("Game ended after max turns. No winner!")
        }
    }

    private fun calculateNewPosition(currentPos: Int, diceRoll: Int): Int {
        val targetPos = currentPos + diceRoll
        if (targetPos > playingBoard.size) return currentPos

        var finalPos = targetPos

        playingBoard.snakes.firstOrNull { it.mouth == finalPos }?.let {
            println("🐍 Bitten by snake at ${it.mouth}, sliding down to ${it.tail}")
            finalPos = it.tail
        }

        playingBoard.ladders.firstOrNull { it.bottom == finalPos }?.let {
            println("🪜 Climbed a ladder from ${it.bottom} to ${it.top}")
            finalPos = it.top
        }

        return finalPos
    }

    private fun printCurrentPositions() {
        println("📍 Player Positions:")
        playingBoard.players.forEach {
            println(" - ${it.name} ➝ ${it.count}")
        }
    }
}
