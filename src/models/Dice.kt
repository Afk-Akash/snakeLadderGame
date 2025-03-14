package models

import kotlin.random.Random

class Dice(
    private val noOfDice: Int
) {
    fun throwDiceOutPut(): Int {
        return (noOfDice until noOfDice*6).random()
    }
}