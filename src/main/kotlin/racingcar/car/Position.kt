package racingcar.car


data class Position(val value: Int = 0) {
    init {
        require(value in MIN_POSITION..MAX_POSITION) {
            "Position must be between $MIN_POSITION and $MAX_POSITION"
        }
    }

    fun increase(): Position {
        return Position(value + 1)
    }

    companion object {
        const val MIN_POSITION = 0
        const val MAX_POSITION = 1000
    }

}
