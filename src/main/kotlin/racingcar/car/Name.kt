package racingcar.car

data class Name(val value: String) {
    init {
        require(value.length <= 5) { "Car name cannot be longer than 5 characters" }
        require(value.isNotEmpty()) { "Car name cannot be empty" }
        require(!value.contains("\\s".toRegex())) { "Car name cannot contain whitespaces" }
    }
}
