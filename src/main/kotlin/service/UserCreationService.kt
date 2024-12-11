package service

import dao.KeycloakUserCreation
import jakarta.enterprise.context.ApplicationScoped
import resource.dto.UserCreationRequest

@ApplicationScoped
class UserCreationService(
    private val userCreationDao: KeycloakUserCreation
) {

    fun createUser(user: UserCreationRequest) {
        userCreationDao.createNewFreeKeycloakUser(user)
    }

    fun deleteUser(username: String) {
        userCreationDao.deleteUser(username)
    }
}