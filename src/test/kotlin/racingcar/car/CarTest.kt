package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `should be initialized when a name is given as argument`() {
        // given
        val name = "Rosie"

        // when
        val car = Car.from(name)

        // then
        assertThat(car).isInstanceOf(Car::class.java)
    }

}