package racingcar

import racingcar.domain.Car

class GameManager(
    val cars: List<Car>,
) {

    fun randomMoveCars(numberGenerator: NumberGenerator): GameManager {
        val movedCars = cars.map { car ->
            val randomNumber = numberGenerator.generate(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX)
            if (randomNumber < MOVE_THRESHOLD) car
            else car.move()
        }
        return GameManager(movedCars)
    }

    fun decideWinners() = cars.maxByOrNull { it.position }
        ?.let { maxCar -> cars.filter { it.position == maxCar.position } }
        ?: emptyList()

    companion object {
        private const val RANDOM_NUMBER_MIN = 0
        private const val RANDOM_NUMBER_MAX = 9
        private const val MOVE_THRESHOLD = 4
    }
}
