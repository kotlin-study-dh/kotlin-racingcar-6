package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `should increase distance when should move`() {
        val car = Car("hyoen", 0)
        car.move(true)
        assertThat(car.distance).isEqualTo(1)
    }

    @Test
    fun `should not increase distance when should not move`() {
        val car = Car("hyoen", 0)
        car.move(false)
        assertThat(car.distance).isEqualTo(0)
    }
}