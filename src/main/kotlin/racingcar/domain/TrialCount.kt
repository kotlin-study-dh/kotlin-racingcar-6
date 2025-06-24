package racingcar.domain

data class TrialCount(val number: Int) {

    init {
        require(number in MIN_TRIAL_COUNT..MAX_TRIAL_COUNT) {
            "Trial count must be an integer between $MIN_TRIAL_COUNT and $MAX_TRIAL_COUNT"
        }
    }

    companion object {
        private const val MIN_TRIAL_COUNT = 1
        private const val MAX_TRIAL_COUNT = 10
    }
}
