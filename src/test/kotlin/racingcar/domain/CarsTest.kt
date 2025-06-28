package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `should return Cars when names given`() {
        assertEquals(
            Cars(listOf(Car("hyeon", Distance(0)), Car("chung", Distance(0)), Car("gibeo", Distance(0)))),
            Cars.of(listOf("hyeon", "chung", "gibeo"))
        )
    }

    @Test
    fun `should return cars who went farthest`() {
        val loserCar = Car("hyeon", Distance(1))
        val winnerCar1 = Car("chung", Distance(3))
        val winnerCar2 = Car("gibeo", Distance(3))
        val cars = Cars(listOf(loserCar, winnerCar1, winnerCar2))

        val farthestCars = cars.findFarthestCars()

        assertThat(farthestCars).containsExactlyInAnyOrder(winnerCar1, winnerCar2)
    }

    @Test
    fun `should return one farthest car when distance is farthest`() {
        val loserCar1 = Car("hyeon", Distance(1))
        val loserCar2 = Car("chung", Distance(2))
        val winnerCar = Car("gibeo", Distance(3))
        val cars = Cars(listOf(loserCar1, loserCar2, winnerCar))

        val farthestCars = cars.findFarthestCars()

        assertThat(farthestCars).containsExactlyInAnyOrder(winnerCar)
    }

    @Test
    fun `should return many farthest cars when distance is farthest`() {
        val winnerCar1 = Car("chung", Distance(3))
        val loserCar = Car("hyeon", Distance(1))
        val winnerCar2 = Car("gibeo", Distance(3))
        val cars = Cars(listOf(winnerCar1, loserCar, winnerCar2))

        val farthestCars = cars.findFarthestCars()

        assertThat(farthestCars).containsExactlyInAnyOrder(winnerCar1, winnerCar2)
    }
}