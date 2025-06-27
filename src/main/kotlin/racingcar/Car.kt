package racingcar

class Car(private val name: String,
          private var distance: Int) {

    fun move(shouldMove: Boolean) {
        if (shouldMove) distance++
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
