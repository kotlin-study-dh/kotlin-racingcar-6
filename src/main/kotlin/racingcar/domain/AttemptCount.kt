package racingcar.domain

class AttemptCount(
    count: Int,
) {
    var count: Int = count
        private set

    init {
        require(count in MIN_ATTEMPT_COUNT..MAX_ATTEMPT_COUNT) { "Attempt count must be between $MIN_ATTEMPT_COUNT and $MAX_ATTEMPT_COUNT." }
    }

    fun decrement() {
        check(canAttempt()) { "Attempt count cannot decrement below zero." }
        count--
    }

    fun canAttempt() = count > 0

    companion object {
        private const val MIN_ATTEMPT_COUNT = 1
        private const val MAX_ATTEMPT_COUNT = 10
    }
}
