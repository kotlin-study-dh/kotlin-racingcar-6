package racingcar.domain

import racingcar.MovementRule

class Cars(val cars: List<Car>) {

    companion object {
        fun of(names: List<String>): Cars {
            return Cars(names.map { name -> Car(name) }.toList())
        }
    }

    fun move(movementRule: MovementRule) {
        cars.forEach { car -> car.move(movementRule.shouldMove()) }
    }

    fun findFarthestCars(): Set<Car> {
        val maxDistance = cars.maxOf { it.distance }
        return cars.filter { it.distance == maxDistance }.toSet()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cars

        return cars == other.cars
    }

    override fun hashCode(): Int {
        return cars.hashCode()
    }
}
