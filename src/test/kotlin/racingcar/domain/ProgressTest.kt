package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.domain.participant.Progress

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

    @Test
    fun `increase progress`() {
        // given
        val progress = Progress(0)

        // when
        val actual = progress.increase(3)

        // then
        assertEquals(Progress(3), actual)
    }
}