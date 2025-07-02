package racingcar.view

object Output {

    fun printRaceLog(logs: List<List<Pair<String, Long>>>) {
        println("실행 결과")
        logs.forEach {
            it.forEach {
                print("${it.first} : ")
                println("-".repeat(it.second.toInt()))
            }
            println()
        }
    }

    fun printWinner(winners: List<String>) {
        print("최종 우승자 : ")
        println(winners.joinToString(", "))
    }
}