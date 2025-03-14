import models.PlayingBoard

class GameEngine(
    private val playingBoard: PlayingBoard
) {

    fun init() {
        while(true) {
            val turn = playingBoard.players.removeLast()
            playingBoard.players.addFirst(turn)

            val point = playingBoard.dice.throwDiceOutPut()
            println()
            println("${turn.name} is at : ${turn.count}")
            println("its ${turn.name} turn and you have got the point: $point")

            if(point + turn.count > playingBoard.size){
                println("You can't use these points, wait for next turn")
                continue
            }
            turn.count += point
            for (snake in playingBoard.snakes) {
                if(snake.mouth == turn.count){
                    turn.count = snake.tail
                    println("You are bitten by snake at ${snake.mouth}, you are now at ${snake.tail}")
                    break
                }
            }
            for (ladder in playingBoard.ladders){
                if(ladder.bottom == turn.count){
                    turn.count = ladder.top
                    println("You are getting ladder support at ${ladder.bottom}, you are now at ${ladder.top}")

                    continue
                }
            }
            if(turn.count == playingBoard.size){
                println("Winner of this game is: ${turn.name}")
                break
            }
        }
    }
}