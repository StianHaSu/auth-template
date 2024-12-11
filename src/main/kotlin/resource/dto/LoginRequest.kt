package resource.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequest(
    val username: String,
    val password: String,
    @JsonProperty("grant_type") val grantType: String = "password",
    val scope: String = "openid",
)
