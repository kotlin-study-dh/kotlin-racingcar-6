package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {

    override fun generate(numberMin: Int, numberMax: Int): Int {
        return Randoms.pickNumberInRange(numberMin, numberMax)
    }
}
