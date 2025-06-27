package racingcar

import camp.nextstep.edu.missionutils.Randoms

class MovementRule {
    fun isSatisfied(): Boolean {
        return Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX) >= THRESHOLD
    }

    companion object {
        val NUMBER_MIN = 0
        val NUMBER_MAX = 9
        val THRESHOLD = 4
    }
}
