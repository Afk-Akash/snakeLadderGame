package models

class PlayingBoard(
    val size: Int,
    val players: ArrayDeque<Player>,
    val snakes: List<Snake>,
    val ladders: List<Ladder>,
    val dice: Dice
) {
    fun init() {
        while(true) {
            val turn = players.removeLast()
            players.addFirst(turn)

            val point = dice.throwDiceOutPut()
            println()
            println("${turn.name} is at : ${turn.count}")
            println("its ${turn.name} turn and you have got the point: $point")

            if(point + turn.count > size){
                println("You can't use these points, wait for next turn")
                continue
            }
            turn.count += point
            for (snake in snakes) {
                if(snake.mouth == turn.count){
                    turn.count = snake.tail
                    println("You are bitten by snake at ${snake.mouth}, you are now at ${snake.tail}")
                    break
                }
            }
            for (ladder in ladders){
                if(ladder.bottom == turn.count){
                    turn.count = ladder.top
                    println("You are getting ladder support at ${ladder.bottom}, you are now at ${ladder.top}")

                    continue
                }
            }
            if(turn.count == size){
                println("Winner of this game is: ${turn.name}")
                break
            }
        }
    }
}