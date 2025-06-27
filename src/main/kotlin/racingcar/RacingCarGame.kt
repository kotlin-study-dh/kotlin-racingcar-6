package racingcar

class RacingCarGame {
    val inputView = InputView()
    val outputView = OutputView()

    fun start() {

    }

    private inline fun <T> retry(crossinline block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: Exception) {
                println("[ERROR] ${e.message}")
            }
        }
    }
}
