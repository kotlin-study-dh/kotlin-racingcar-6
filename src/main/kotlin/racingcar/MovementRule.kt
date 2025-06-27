package racingcar

class MovementRule(private val numberGenerator: NumberGenerator) {

    fun shouldMove(): Boolean {
        return numberGenerator.generate(NUMBER_MIN, NUMBER_MAX) >= THRESHOLD
    }

    companion object {
        val NUMBER_MIN = 0
        val NUMBER_MAX = 9
        val THRESHOLD = 4
    }
}
