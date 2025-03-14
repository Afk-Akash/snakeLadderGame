package models

class Snanke(
    val mouth: Int,
    val tail: Int
) {
    init {
        require(mouth > tail) {"Snake mouth should be always greater than its tail"}
    }
}