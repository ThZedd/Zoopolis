package pt.iade.ei.zoopolis.models

import java.io.Serializable

data class EnclosuresDTO(
    val animalClass: String,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val mapsId: String,
    val name: String,
    val supportedAmount: Int
): Serializable