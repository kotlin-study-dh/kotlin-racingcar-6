package racingcar.domain.powerstrategy

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

object RandomPowerStrategy : PowerStrategy {

    override fun generatePower(): Int = pickNumberInRange(0, 9)
}
