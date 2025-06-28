package racingcar.domain

import racingcar.MovementRule

class Cars(private val _cars: List<Car>) {

    val cars: List<Car>
        get() = _cars.toList()

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

        return _cars == other._cars
    }

    override fun hashCode(): Int {
        return _cars.hashCode()
    }

    companion object {
        fun of(names: List<String>): Cars {
            require(names.distinct().size == names.size) { "Name shouldn't be duplicated" }
            return Cars(names.map { name -> Car(name) }.toList())
        }
    }
}
