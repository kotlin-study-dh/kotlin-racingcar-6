package racingcar.domain.rule

data class ForwardGambler(val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator()) {

    fun gamble(threshold: Int, strategy: (RandomNumberGenerator) -> Int) = strategy(randomNumberGenerator) >= threshold
}