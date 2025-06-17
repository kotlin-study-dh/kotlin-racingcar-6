package racingcar.game

data class GameCount(val value: Int) {
    init {
        require(value in MIN_GAME_COUNT..MAX_GAME_COUNT) {
            "Game count must be between $MIN_GAME_COUNT and $MAX_GAME_COUNT"
        }
    }

    companion object {
        const val MIN_GAME_COUNT = 1
        const val MAX_GAME_COUNT = 999
    }
}