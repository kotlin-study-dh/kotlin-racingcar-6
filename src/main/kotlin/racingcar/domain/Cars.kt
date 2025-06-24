package racingcar.domain

import racingcar.common.PowerStrategy

class Cars private constructor(val cars: List<Car>) {

    fun move(powerStrategy: PowerStrategy) {
        cars.forEach { it.moveForward(powerStrategy.generatePower()) }
    }

    companion object {
        fun withNames(names: List<String>): Cars {
            require(names.size >= MIN_CAR_AMOUNT) { "There must be at least $MIN_CAR_AMOUNT cars in the race." }
            return Cars(names.map { Car(it) })
        }

        const val MIN_CAR_AMOUNT = 2
    }
}
