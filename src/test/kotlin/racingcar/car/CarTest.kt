package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `creates a car when a name is given`() {
        // given
        val name = "Rosie"

        // when
        val car = Car.from(name)

        // then
        assertThat(car).isInstanceOf(Car::class.java)
    }

    @Test
    fun `returns initial position as 0`() {
        // given
        val car = Car.from("Mycar")

        // when
        val position = car.currentPosition()

        // then
        assertThat(position).isEqualTo(0)
    }

    @Test
    fun `increases position when moved forward`() {
        // given
        val car = Car.from("Rosie")

        // when
        car.forward()

        // then
        assertThat(car.currentPosition()).isEqualTo(1)
    }

}