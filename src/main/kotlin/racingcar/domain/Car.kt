package racingcar.domain

class Car(val name: String,
          var distance: Int) {

    constructor(name: String) : this(
        name, 0
    )

    fun move(shouldMove: Boolean) {
        if (shouldMove) distance++
    }

    fun isFartherThan(car: Car): Boolean {
        return this.distance.isBiggerThan(car.distance)
    }

    fun isSameDistance(car: Car): Boolean {
        return this.distance.isSameWith(car.distance)
    }

    override fun equals(other: Any?): Boolean {
        if (this===other) return true
        if (javaClass!=other?.javaClass) return false

        other as Car

        return name==other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
