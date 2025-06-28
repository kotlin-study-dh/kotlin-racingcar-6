package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DistanceTest {

    @Test
    fun `should return increased distance when increase`() {
        val distance = Distance(0)
        distance.increase()
        assertEquals(Distance(1), distance)
    }

    @Test
    fun `should compare distance by value`() {
        val distance = Distance(5)
        val compareValue = distance.compareTo(Distance(6))
        assertEquals(-1, compareValue)
    }
}