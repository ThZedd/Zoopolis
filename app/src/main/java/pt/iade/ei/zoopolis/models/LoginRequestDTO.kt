package pt.iade.ei.zoopolis.models

import java.io.Serializable

data class LoginRequestDTO(
    val email: String,
    val password: String
): Serializable