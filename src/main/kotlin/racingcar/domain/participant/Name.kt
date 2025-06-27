package racingcar.domain.participant

data class Name(val name: String) {

    init {
        require(name.length <= MAX_NAME_LENGTH) {
            "name length must be less and equal than $MAX_NAME_LENGTH"
        }
        require(!name.isBlank()) {
            "name must not be blank"
        }
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
    }
}