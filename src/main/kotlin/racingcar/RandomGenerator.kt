package racingcar

import camp.nextstep.edu.missionutils.Randoms

object RandomGenerator : NumberGenerator {

    override fun generate(min: Int, max: Int) = Randoms.pickNumberInRange(min, max)
}
