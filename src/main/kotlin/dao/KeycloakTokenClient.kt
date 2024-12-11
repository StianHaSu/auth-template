package dao

import resource.dto.TokenResponse
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@RegisterRestClient(configKey = "login")
interface KeycloakTokenClient {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun getAccessToken(
        @FormParam("grant_type") grantType: String,
        @FormParam("client_id") clientId: String,
        @FormParam("client_secret") clientSecret: String,
        @FormParam("username") username: String,
        @FormParam("password") password: String): TokenResponse

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun refreshAccessToken(
        @FormParam("grant_type") grantType: String,
        @FormParam("client_id") clientId: String,
        @FormParam("client_secret") clientSecret: String,
        @FormParam("refresh_token") refreshToken: String
    ): TokenResponse
}