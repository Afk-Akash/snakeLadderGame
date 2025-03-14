package models

class PlayingBoard(
    val size: Int,
    val players: ArrayDeque<Player>,
    val snakes: List<Snake>,
    val ladders: List<Ladder>,
    val dice: Dice
)