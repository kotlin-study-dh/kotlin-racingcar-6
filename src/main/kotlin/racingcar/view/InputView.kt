package racingcar.view

import camp.nextstep.edu.missionutils.Console

fun readCarsName(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine().replace(" ", "").split(",")
}

fun readTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine().toIntOrNull()
        ?.also { require(it > 0) { "Try count must be positive" } }
        ?: throw IllegalArgumentException("Try count must be positive")
}
