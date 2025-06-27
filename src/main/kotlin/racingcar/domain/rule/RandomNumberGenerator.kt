package racingcar.domain.rule

import camp.nextstep.edu.missionutils.Randoms

open class RandomNumberGenerator {

    open fun generateInRange(start: Int, end: Int): Int = Randoms.pickNumberInRange(start, end)
}