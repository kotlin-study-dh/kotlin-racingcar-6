package racingcar.support

import racingcar.generator.NumberGenerator

class FixedNumberGenerator(
    private vararg val fixedNumber: Int,
) : NumberGenerator {
    private var index = 0

    override fun generate(): Int {
        check(index < fixedNumber.size) { "No more fixed numbers available" }
        return fixedNumber[index++]
    }
}
