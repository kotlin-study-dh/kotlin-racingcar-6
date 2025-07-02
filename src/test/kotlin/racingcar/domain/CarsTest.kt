package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.support.FixedNumberGenerator

class CarsTest {
    @Test
    fun `fails to create Cars when car count is greater than MAX_CAR_COUNT`() {
        // given
        val invalidCarCount = 11
        val carNames = List(invalidCarCount) { "Car$it" }

        // when & then
        assertThatThrownBy { Cars(carNames) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car count must be less than or equal to 10")
    }

    @Test
    fun `fails to create Cars when car names are not unique`() {
        // given
        val carNames = listOf("Car1", "Car2", "Car1")

        // when & then
        assertThatThrownBy { Cars(carNames) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car names must be unique")
    }

    @Test
    fun `succeeds in creating Cars when car count is less than or equal to MAX_CAR_COUNT and names are unique`() {
        // given
        val validCarCount = 10
        val carNames = List(validCarCount) { "Car$it" }

        // when
        val cars = Cars(carNames)

        // then
        assertThat(cars.cars).hasSize(validCarCount)
        assertThat(cars.cars.map { it.name }).containsExactlyInAnyOrderElementsOf(carNames)
    }

    @Test
    fun `moves all cars`() {
        // given
        val carNames = listOf("Car1", "Car2", "Car3")
        val cars = Cars(carNames)
        val numberGenerator = FixedNumberGenerator(4, 5, 6) // All cars will move

        // when
        cars.moveAll(numberGenerator)

        // then
        assertThat(cars.cars).allMatch { it.position == 1 }
    }

    @Test
    fun `gets winners when multiple cars have the same maximum position`() {
        // given
        val carNames = listOf("Car1", "Car2", "Car3")
        val cars = Cars(carNames)
        val numberGenerator = FixedNumberGenerator(3, 4, 4) // Two cars will move

        // when
        cars.moveAll(numberGenerator)

        // then
        val winners = cars.getWinners()
        assertThat(winners).hasSize(2)
        assertThat(winners.map { it.name }).containsExactlyInAnyOrder("Car2", "Car3")
    }

    @Test
    fun `gets winners when a single car has the maximum position`() {
        // given
        val carNames = listOf("Car1", "Car2", "Car3")
        val cars = Cars(carNames)
        val numberGenerator = FixedNumberGenerator(5, 3, 3) // Only one car will move

        // when
        cars.moveAll(numberGenerator)

        // then
        val winners = cars.getWinners()
        assertThat(winners).hasSize(1)
        assertThat(winners.first().name).isEqualTo("Car1")
    }
}
