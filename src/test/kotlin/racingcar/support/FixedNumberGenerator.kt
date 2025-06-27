package racingcar.support

import racingcar.generator.NumberGenerator

class FixedNumberGenerator(
    private val fixedNumber: Int,
) : NumberGenerator {
    override fun generate(): Int {
        return fixedNumber
    }
}
