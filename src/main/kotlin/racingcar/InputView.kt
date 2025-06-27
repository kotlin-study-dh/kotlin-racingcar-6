package racingcar

import camp.nextstep.edu.missionutils.Console

class InputView() {
    fun readNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = read().split(",").map { it -> it.trim() }
        require(names.all { it -> it.length <= 5 }) { "Name should be same or under 5 characters" }
        require(names.distinct().size==names.size) {"Name shouldn't be duplicated"}
        return names
    }

    fun readRidingCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return read().toInt()
    }

    fun read(): String = Console.readLine()
}