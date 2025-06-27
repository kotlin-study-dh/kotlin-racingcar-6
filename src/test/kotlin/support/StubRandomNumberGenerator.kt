package support

import racingcar.domain.rule.RandomNumberGenerator

class StubRandomNumberGenerator : RandomNumberGenerator() {

    override fun generateInRange(start: Int, end: Int) = 5
}