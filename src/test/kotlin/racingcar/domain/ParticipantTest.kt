package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.domain.participant.Name
import racingcar.domain.participant.Participant
import racingcar.domain.participant.Progress

class ParticipantTest {

    @Test
    fun `increase progress step must be 1`() {
        // given
        val participant = Participant(Name("name"))

        // when
        val actual = participant.forward()

        // then
        val expect = Participant(Name("name"), Progress(1L))
        assertEquals(expect, actual)
    }
}