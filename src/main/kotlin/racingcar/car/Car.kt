package racingcar.car

class Car(val name: Name, val position: Position = Position()) {

    companion object {
        fun from(name: String): Car {
            return Car(Name(name))
        }
    }

    fun forward(): Car {
        val nextPosition = position.increase()
        return Car(name, nextPosition)
    }
}