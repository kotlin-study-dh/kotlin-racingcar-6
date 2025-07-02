package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.domain.participant.Name

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

    @Test
    fun `throw an exception if name is blank`() {
        // given
        val name = " "

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            Name(name)
        }
    }
}