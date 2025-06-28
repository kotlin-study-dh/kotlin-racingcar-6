package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `should throw exception if the name is over 5 characters`() {
        assertThrows<IllegalArgumentException> { Car("hyeonj") }
    }

    @Test
    fun `should init distance as 0 when only name given`() {
        val car = Car("hyoen")
        assertThat(car.distance).isEqualTo(Distance(0))
    }

    @Test
    fun `should increase distance when should move`() {
        val car = Car("hyeon", Distance(0))
        car.move(true)
        assertThat(car.distance).isEqualTo(Distance(1))
    }

    @Test
    fun `should not increase distance when should not move`() {
        val car = Car("hyeon", Distance(0))
        car.move(false)
        assertThat(car.distance).isEqualTo(Distance(0))
    }
}