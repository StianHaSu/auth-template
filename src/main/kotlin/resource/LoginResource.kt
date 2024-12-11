package resource

import service.LoginService
import resource.dto.TokenResponse
import resource.dto.UserCredentials
import jakarta.ws.rs.*

@Path("/login")
class LoginResource (
    val loginService: LoginService
){
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    fun login(userCredentials: UserCredentials): TokenResponse {
        return loginService.login(userCredentials)
    }

    @POST
    @Path("/refresh")
    @Produces("application/json")
    @Consumes("text/plain")
    fun refreshAccessToken(refreshToken: String): TokenResponse {
        return loginService.refreshAccessToken(refreshToken)
    }
}
