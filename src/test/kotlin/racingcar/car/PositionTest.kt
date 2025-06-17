package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositionTest {

    @Test
    fun `initializes with default value 0`() {
        assertThat(Position().value).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 1001, 100000])
    fun `throws if value is out of range 0 to 1000`(value: Int) {
        assertThatThrownBy { Position(value) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `returns new position increased by 1`() {
        val previous = Position(0)
        val current = previous.increase()
        assertThat(current).isEqualTo(Position(1))
    }
}
