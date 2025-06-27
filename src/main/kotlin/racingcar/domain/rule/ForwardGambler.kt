package racingcar.domain.rule

class ForwardGambler {

    companion object {
        const val FORWARD_THRESHOLD = 4
    }

    fun gamble(strategy: () -> Int) = strategy() >= FORWARD_THRESHOLD
}