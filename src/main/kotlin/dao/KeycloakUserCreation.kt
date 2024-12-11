package dao

import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.keycloak.admin.client.Keycloak
import org.keycloak.representations.idm.CredentialRepresentation
import org.keycloak.representations.idm.UserRepresentation
import resource.dto.UserCreationRequest

@ApplicationScoped
class KeycloakUserCreation (
    private val keycloak: Keycloak,
    @ConfigProperty(name = "quarkus.keycloak.admin-client.realm") val realm: String
) {

    fun createNewFreeKeycloakUser(userRequest: UserCreationRequest) {
        val user1 = UserRepresentation()
        user1.username = userRequest.username
        user1.email = userRequest.email
        user1.firstName = userRequest.firstName
        user1.lastName = userRequest.lastName
        user1.isEnabled = true
        user1.realmRoles = listOf("regular-user")
        user1.credentials = listOf(CredentialRepresentation().apply {
            type = CredentialRepresentation.PASSWORD
            value = userRequest.password
            isTemporary = false
        })

        keycloak.realm(realm).users().create(user1)
    }

    fun deleteUser(username: String) {
        val user = keycloak.realm(realm).users().search(username)
        if (user.isNotEmpty()) {
            keycloak.realm(realm).users().delete(user[0].id)
        }
    }
}