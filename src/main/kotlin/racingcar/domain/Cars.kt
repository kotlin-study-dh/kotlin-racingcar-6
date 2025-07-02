package racingcar.domain

import racingcar.generator.NumberGenerator

class Cars(
    carNames: List<String>,
) {
    private val _cars: List<Car>
    val cars: List<Car>
        get() = _cars.toList()

    init {
        require(carNames.size <= MAX_CAR_COUNT) { "Car count must be less than or equal to $MAX_CAR_COUNT" }
        require(carNames.distinct().size == carNames.size) { "Car names must be unique" }
        _cars = carNames.map { Car(it) }
    }

    fun moveAll(numberGenerator: NumberGenerator) = _cars.forEach { it.move(numberGenerator) }

    fun getWinners(): List<Car> {
        val maxPosition = _cars.maxOf { it.position }
        return _cars.filter { it.position == maxPosition }
    }

    companion object {
        private const val MAX_CAR_COUNT = 10
    }
}
