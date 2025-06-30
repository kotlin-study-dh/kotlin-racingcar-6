package racingcar.domain

import racingcar.common.PowerStrategy

class Cars private constructor(val cars: List<Car>) {

    fun move(powerStrategy: PowerStrategy) {
        cars.forEach { it.moveForward(powerStrategy.generatePower()) }
    }

    fun winners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        fun withNames(names: List<String>): Cars {
            require(names.size == names.distinct().size) {
                "No duplication allowed for car names."
            }

            require(names.size >= MIN_CAR_AMOUNT) {
                "There must be between $MIN_CAR_AMOUNT and $MAX_CAR_AMOUNT cars in the race."
            }

            return Cars(names.map { Car(it) })
        }

        const val MIN_CAR_AMOUNT = 2
        const val MAX_CAR_AMOUNT = 15
    }
}
