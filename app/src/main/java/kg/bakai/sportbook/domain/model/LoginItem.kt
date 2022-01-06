package kg.bakai.sportbook.domain.model

data class LoginItem(
    val name: String,
    val type: FieldType
)

enum class FieldType {
    None,
    Text,
    Number,
    Double
}
