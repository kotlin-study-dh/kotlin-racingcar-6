package racingcar.generator

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)

    companion object {
        const val MIN_NUMBER = 0
        const val MAX_NUMBER = 9
    }
}
