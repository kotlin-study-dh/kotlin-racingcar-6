package racingcar.domain.participant

data class Participant (val name: Name, val progress: Progress = Progress()) {

    companion object {
        const val STEP_SIZE = 1L;
    }

    fun forward() : Participant {
        val increasedProgress = progress.increase(STEP_SIZE)
        return Participant(name, increasedProgress)
    }
}