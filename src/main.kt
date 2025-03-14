import models.*

fun main() {
    val playingBoard: PlayingBoard
    val player1 = Player("Akash")
    val player2 = Player("Vikas")

    val dice = Dice(2)

    val snake1 = Snake(20, 10)
    val snake2 = Snake(30, 5)
    val snake3 = Snake(40, 25)
    val snake4 = Snake(49, 20)
    val snakes = listOf(snake1, snake2, snake3, snake4)

    val players = ArrayDeque<Player>()
    players.add(player1)
    players.add(player2)

    val ladder1 = Ladder(15, 20)
    val ladder2 = Ladder(28, 42)
    val ladder3 = Ladder(18, 47)
    val ladder4 = Ladder(11, 21)
    val ladders = listOf(ladder4, ladder3, ladder2, ladder1)

    playingBoard = PlayingBoard(50,players, snakes, ladders, dice)

    playingBoard.init()
}