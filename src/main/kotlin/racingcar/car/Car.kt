package racingcar.car

class Car(val name: Name, private var position: Position = Position()) {

    companion object {
        fun from(name: String): Car {
            return Car(Name(name))
        }
    }

    fun forward() {
        position = position.increase()
    }

    fun currentPosition(): Int {
        return position.value
    }
}