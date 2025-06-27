package racingcar.domain

data class Car(
    val name: String,
    val position: Int = 0
) {

    fun move() = this.copy(name, this.position + 1)
}
