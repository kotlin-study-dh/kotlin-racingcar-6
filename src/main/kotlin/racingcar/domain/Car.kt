package racingcar.domain

class Car(
    val name: String,
    var position: Int = INITIAL_CAR_POSITION,
) {
    fun moveForward(power: Int) {
        require(power >= MIN_POWER) { "Power has to be at least $MIN_POWER." }

        if (power >= MIN_MOVABLE_POWER) {
            position++
        }
    }

    companion object {
        const val INITIAL_CAR_POSITION = 0
        const val MIN_POWER = 0
        const val MIN_MOVABLE_POWER = 4
    }
}
