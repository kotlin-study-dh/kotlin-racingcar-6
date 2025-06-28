package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class CarTest {
    @Test
    fun `should init distance as 0 when only name given`() {
        val car = Car("hyoen")
        assertThat(car.distance).isEqualTo(0)
    }

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