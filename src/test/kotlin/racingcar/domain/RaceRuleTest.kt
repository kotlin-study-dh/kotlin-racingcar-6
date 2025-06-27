package racingcar.domain

import org.junit.jupiter.api.Test
import racingcar.domain.participant.Name
import racingcar.domain.participant.Progress
import racingcar.domain.participant.Racer
import racingcar.domain.participant.Racers
import racingcar.domain.rule.ForwardGambler
import racingcar.domain.rule.RaceRule
import support.StubRandomNumberGenerator

class RaceRuleTest {

    @Test
    fun `run racing game via exist rule`() {
        // given
        val racers = Racers(listOf(Racer(Name("A")), Racer(Name("B"))))
        val raceRule = RaceRule(ForwardGambler(StubRandomNumberGenerator()))

        // when
        val actual = raceRule.evaluate(racers)

        // then
        val expect = Racers(listOf(Racer(Name("A"), Progress(1L)), Racer(Name("B"), Progress(1L))))
        assert(actual == expect)
    }
}