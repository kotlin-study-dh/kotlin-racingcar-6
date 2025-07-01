package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @Test
    fun `should fail if car name is longer than five characters`() {
        Assertions.assertThatThrownBy { Name("Haaallo") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `should fail if car name is empty`() {
        Assertions.assertThatThrownBy { Name("") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", " hi", "W I N", "Kot ", "  ", "\t"])
    fun `should fail if car name contains blank characters`(nameWithBlank: String) {
        Assertions.assertThatThrownBy { Name(nameWithBlank) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

}