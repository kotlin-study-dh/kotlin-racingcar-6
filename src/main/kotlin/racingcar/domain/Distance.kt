package racingcar.domain

class Distance(private var _value: Int) : Comparable<Distance> {

    val value: Int
        get() = _value

    fun increase() {
        _value++
    }

    override fun compareTo(other: Distance): Int {
        return this.value.compareTo(other.value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Distance

        return _value == other._value
    }

    override fun hashCode(): Int {
        return _value
    }
}
