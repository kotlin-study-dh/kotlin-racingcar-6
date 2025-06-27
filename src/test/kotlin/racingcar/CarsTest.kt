package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `should return Cars when names given`() {
        assertEquals(
            Cars(listOf(Car(HJ, 0), Car(CR, 0), Car(GB, 0))),
            Cars.of(listOf(HJ, CR, GB))
        )
    }

    companion object {
        val HJ = "hyeonji"
        val CR = "chungryul"
        val GB = "gibeom"
    }
}