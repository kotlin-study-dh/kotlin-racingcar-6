package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `should return Cars when names given`() {
        assertEquals(
            Cars(listOf(Car(HJ), Car(CR), Car(GB))),
            Cars.of(listOf(HJ, CR, GB))
        )
    }

    companion object {
        val HJ = "hyeonji"
        val CR = "chungryul"
        val GB = "gibeom"
    }
}