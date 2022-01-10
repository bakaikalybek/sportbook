package kg.bakai.sportbook.domain.model

data class User(
    val name: String?,
    var currentWeight: Float?,
    val currentHeight: Float?,
    var goalWeight: Float?,
    val age: Int?
)
