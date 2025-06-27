package racingcar.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `throw exception name of car is over 5 characters`() {
        assertThat(
        assertThrows<IllegalArgumentException> { Car("kayoung", 0) }.message)
            .isEqualTo("Car name must be at least 5 characters")
    }

    @Test
    fun `verify position increase when car move`() {
        val car = Car("hyeon", 0)
        val movedCar = car.move()

        assertThat(movedCar.position).isEqualTo(car.position + 1)
    }
}
