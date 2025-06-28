package racingcar.domain

class Car(
    val name: String,
    private val _distance: Distance
) {

    val distance: Distance
        get() = _distance

    constructor(name: String) : this(
        name, Distance(0)
    )

    fun move(shouldMove: Boolean) {
        if (shouldMove) _distance.increase()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
