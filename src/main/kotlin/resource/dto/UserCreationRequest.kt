package resource.dto

data class UserCreationRequest(
    val username: String,
    val password: String,
    val email: String,
    val firstName: String,
    val lastName: String
)
