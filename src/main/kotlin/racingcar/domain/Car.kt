package racingcar.domain

data class Car(
    val name: String,
    val position: Int = 0
) {
    init {
        require(name.length <= 5) { "Car name must be at least 5 characters" }
    }

    fun move() = this.copy(name, this.position + 1)
}
