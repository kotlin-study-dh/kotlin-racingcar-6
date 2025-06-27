package racingcar

class Cars(val cars: List<Car>) {

    companion object {
        fun of(names: List<String>): Cars {
            return Cars(names.map { name -> Car(name) }.toList())
        }
    }

    fun move(movementRule: MovementRule) {
        cars.forEach { car -> car.move(movementRule.shouldMove()) }
    }

    fun findFarestCars(): List<Car> {
        var maxDistance = 0
        cars.forEach { car ->
            if (car.distance > maxDistance) maxDistance = car.distance
        }
       return cars.filter { car -> car.distance == maxDistance }
    }

    override fun equals(other: Any?): Boolean {
        if (this===other) return true
        if (javaClass!=other?.javaClass) return false

        other as Cars

        return cars==other.cars
    }

    override fun hashCode(): Int {
        return cars.hashCode()
    }
}