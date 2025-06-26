package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProgressTest {

    @Test
    fun `throw an exception if the progress is less than zero`() {
        // given
        val progress = -1L;

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            Progress(progress)
        }
    }
}