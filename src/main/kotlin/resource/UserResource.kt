package resource

import jakarta.ws.rs.DELETE
import service.UserCreationService
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import resource.dto.UserCreationRequest

@Path("/users")
class UserResource(
    val userCreationService: UserCreationService
) {

    @POST
    fun createUser(
        user: UserCreationRequest
    ) {
        userCreationService.createUser(user)
    }
}