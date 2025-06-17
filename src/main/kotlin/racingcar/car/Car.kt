package racingcar.car

class Car(
    val name: Name,
) {
    companion object {
        fun from(name: String): Car {
            return Car(Name(name))
        }
    }
}