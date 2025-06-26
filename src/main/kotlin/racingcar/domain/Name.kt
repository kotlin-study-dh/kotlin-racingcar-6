package racingcar.domain

class Name(name: String) {

    val name:String = name;

    init {
        require(name.length <= MAX_NAME_LENGTH) {
            "name length must be less and equal than $MAX_NAME_LENGTH"
        }
    }

    companion object {
        const val MAX_NAME_LENGTH = 5;
    }
}