package racingcar.game

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameCountTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 1000])
    fun `throw exception when the value out of range`(value: Int) {
        assertThatThrownBy { GameCount(value) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

}