package racingcar.car


data class Position(val value: Int = 0): Comparable<Position> {
    init {
        require(value in MIN_POSITION..MAX_POSITION) {
            "Position must be between $MIN_POSITION and $MAX_POSITION"
        }
    }

    fun increase(): Position {
        return Position(value + 1)
    }

    override fun compareTo(other: Position): Int {
        return value.compareTo(other.value)
    }

    companion object {
        const val MIN_POSITION = 0
        const val MAX_POSITION = 1000
    }

}
