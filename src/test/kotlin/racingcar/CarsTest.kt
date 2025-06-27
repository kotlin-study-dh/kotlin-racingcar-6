package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `should return Cars when names given`() {
        assertEquals(
            Cars(listOf(Car("hyeon", 0), Car("chung", 0), Car("gibeo", 0))),
            Cars.of(listOf("hyeon", "chung", "gibeo"))
        )
    }

    @Test
    fun `should return cars who went farest`() {
        val loserCar = Car("hyeon", 1)
        val winnerCar1 = Car("chung", 3)
        val winnerCar2 = Car("gibeo", 3)
        val cars = Cars(listOf(loserCar, winnerCar1, winnerCar2))

        val farestCars = cars.findFarestCars()

        assertThat(farestCars).containsExactlyInAnyOrder(winnerCar1, winnerCar2)
    }
}