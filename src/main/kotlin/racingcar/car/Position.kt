package racingcar.car

private const val MIN_POSITION = 0
private const val MAX_POSITION = 1000

data class Position(val value: Int = 0) {
    init {
        require(value in MIN_POSITION..MAX_POSITION) {
            "Position must be between $MIN_POSITION and $MAX_POSITION"
        }
    }

    fun increase(): Position {
        return Position(value + 1)
    }

}
