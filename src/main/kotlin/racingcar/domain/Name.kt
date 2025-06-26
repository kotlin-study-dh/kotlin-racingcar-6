package racingcar.domain

class Name(name: String) {

    val name:String = name

    init {
        require(name.length <= MAX_NAME_LENGTH) {
            "name length must be less and equal than $MAX_NAME_LENGTH"
        }
        require(!name.isBlank()) {
            "name must not be blank"
        }
    }

    companion object {
        const val MAX_NAME_LENGTH = 5;
    }
}