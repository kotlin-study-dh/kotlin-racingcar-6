package racingcar.domain

import racingcar.domain.participant.Name
import racingcar.domain.participant.Racer
import racingcar.domain.participant.Racers
import racingcar.domain.rule.RaceRule

class RacingGame(names: List<String>) {

    var racers: Racers
    val rule: RaceRule

    init {
        racers = Racers(names.map { Racer(Name(it)) })
        rule = RaceRule()
    }

    fun play(round: Int): List<List<Pair<String, Long>>> {
        return (1..round).map {
            val evaluate = rule.evaluate(racers)
            racers = evaluate
            racers.status
        }
    }
}