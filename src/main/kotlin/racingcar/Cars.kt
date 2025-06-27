package racingcar

class Cars(private val cars: List<Car>) {
    companion object {
        fun of(names: List<String>): Cars {
            return Cars(names.map { name -> Car(name) }.toList())
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