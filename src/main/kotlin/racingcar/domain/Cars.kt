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

    fun findFarthestCars(): MutableSet<Car> {
        val farthestCars: MutableSet<Car> = mutableSetOf()
        cars.forEach { car ->
            car.addFartherCar(farthestCars)
        }
        return farthestCars
    }

    private fun Car.addFartherCar(farthestCars: MutableSet<Car>) {
        farthestCars.forEach { car ->
            if (car.isFartherThan(this)) {
                farthestCars.remove(car)
                farthestCars.add(this)
            } else if (car.isSameDistance(this)) {
                farthestCars.add(this)
            }
        }
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
