package racingcar.domain.participant

data class Racer(val name: Name, val progress: Progress = Progress()) {

    companion object {
        const val STEP_SIZE = 1L
    }

    val status
        get() = Pair(name.name, progress.progress)

    fun forward(): Racer {
        val increasedProgress = progress.increase(STEP_SIZE)
        return Racer(name, increasedProgress)
    }
}