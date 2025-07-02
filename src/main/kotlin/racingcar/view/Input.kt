package racingcar.view

import camp.nextstep.edu.missionutils.Console

object Input {

    fun enterParticipants(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val readLine = Console.readLine() ?: throw IllegalStateException("participants can't be null")
        return readLine.split(",")
            .filter { it.isNotBlank() }
    }

    fun enterRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val readLine = Console.readLine() ?: throw IllegalStateException("round number can't be null")
        val round = readLine.toInt()
        require(round > 0) {
            "round number can't be negative"
        }
        return round
    }
}