package racingcar.domain

class Distance(var distance: Int): Comparable<Distance> {

    fun increase() {
        distance++
    }

    override fun compareTo(other: Distance): Int {
        return this.distance.compareTo(other.distance)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Distance

        return distance == other.distance
    }

    override fun hashCode(): Int {
        return distance
    }
}
