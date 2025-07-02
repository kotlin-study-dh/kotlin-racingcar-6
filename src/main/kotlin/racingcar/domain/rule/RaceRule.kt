package racingcar.domain.rule

import racingcar.domain.participant.Racers

data class RaceRule(
    val gambler: ForwardGambler = ForwardGambler()
) {
    companion object {
        const val MIN_SCORE_GENERATE_NUMBER = 0
        const val MAX_SCORE_GENERATE_NUMBER = 9
        const val FORWARD_THRESHOLD = 4
    }

    private val strategy: () -> Boolean = {
        gambler.gamble(FORWARD_THRESHOLD) { randomNumberGenerator ->
            randomNumberGenerator.generateInRange(MIN_SCORE_GENERATE_NUMBER, MAX_SCORE_GENERATE_NUMBER)
        }
    }

    fun evaluateRound(racers: Racers): Racers {
        return 0.until(racers.size)
            .map { it to strategy() }
            .filter { it.second }
            .fold(racers) { acc, i -> acc.forward(i.first) }
    }
}