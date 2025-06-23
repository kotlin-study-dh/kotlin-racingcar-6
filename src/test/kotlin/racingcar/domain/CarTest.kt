package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "abcdef", "가나다", "ab123"])
    fun `throw exception when car name is invalid`(name: String) {
        assertThrows<IllegalArgumentException> { Car(name) }
    }

    @Test
    fun `car moves when the power is 4`() {
        // given
        val car = Car("john")

        // when
        car.moveForward(4)

        // then
        assert(car.position == Car.INITIAL_CAR_POSITION + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3])
    fun `car does not move when the power is not enough`(power: Int) {
        // given
        val car = Car("john")

        // when
        car.moveForward(power)

        // then
        assert(car.position == Car.INITIAL_CAR_POSITION)
    }
}
