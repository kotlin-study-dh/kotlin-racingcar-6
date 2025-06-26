package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NameTest {

    @Test
    fun `throw an exception if the participant name length over the 5`() {
        // given
        val name = "abcdef";

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            Name(name)
        }
    }
}