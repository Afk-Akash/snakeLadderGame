package models

class Ladder(
    val bottom: Int,
    val top: Int
) {
    init {
        require(top > bottom) {"ladder top should be always greater than its bottom"}
    }
}