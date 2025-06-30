package racingcar.domain

class Car(
    val name: String,
    var position: Int = INITIAL_CAR_POSITION,
) {
    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) {
            "Car names must be between $MIN_NAME_LENGTH and $MAX_NAME_LENGTH characters long."
        }
        require(name.matches(ALPHABETIC_PATTERN)) {
            "Car name must only contain alphabetic letters."
        }
    }

    fun moveForward(power: Int) {
        require(power >= MIN_POWER) { "Power has to be at least $MIN_POWER." }

        if (power >= MIN_MOVABLE_POWER) {
            position++
        }
    }

    companion object {
        val ALPHABETIC_PATTERN = "^[a-zA-Z]*$".toRegex()

        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5

        const val INITIAL_CAR_POSITION = 0

        const val MIN_POWER = 0
        const val MIN_MOVABLE_POWER = 4
    }
}
