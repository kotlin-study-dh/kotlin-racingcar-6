package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.participant.Name
import racingcar.domain.participant.Progress
import racingcar.domain.participant.Racer

class ParticipantTest {

    @Test
    fun `increase progress step must be 1`() {
        // given
        val racer = Racer(Name("name"))

        // when
        val actual = racer.forward()

        // then
        val expect = Racer(Name("name"), Progress(1L))
        assertEquals(expect, actual)
    }
}