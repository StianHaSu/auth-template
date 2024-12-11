package service

import resource.dto.TokenResponse
import resource.dto.UserCredentials
import dao.KeycloakTokenClient
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class LoginService (
    @RestClient val loginClient: KeycloakTokenClient,
    @ConfigProperty(name = "quarkus.rest-client.login.client-id") val clientId: String,
    @ConfigProperty(name = "quarkus.rest-client.login.credentials.secret") val clientSecret: String
) {

    fun login(userCredentials: UserCredentials): TokenResponse {
        return loginClient.getAccessToken(
            "password",
            clientId,
            clientSecret,
            userCredentials.username,
            userCredentials.password
        )
    }

    fun refreshAccessToken(refreshToken: String): TokenResponse {
        return loginClient.refreshAccessToken(
            "refresh_token",
            clientId,
            clientSecret,
            refreshToken
        )
    }
}