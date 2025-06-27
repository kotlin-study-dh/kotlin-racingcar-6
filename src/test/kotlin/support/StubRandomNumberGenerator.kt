package support

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.rule.RandomNumberGenerator

class StubRandomNumberGenerator : RandomNumberGenerator() {

    override fun generateInRange(start: Int, end: Int)= 3;
}