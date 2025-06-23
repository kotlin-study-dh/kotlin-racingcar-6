package racingcar.domain

class Cars private constructor(val cars: List<Car>) {

    companion object {
        fun withNames(names: List<String>): Cars {
            require(names.size >= MIN_CAR_AMOUNT) { "There must be at least $MIN_CAR_AMOUNT cars in the race." }
            return Cars(names.map { Car(it) })
        }

        const val MIN_CAR_AMOUNT = 2
    }
}
