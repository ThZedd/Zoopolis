package pt.iade.ei.zoopolis.retrofit

import kotlinx.coroutines.flow.Flow
import pt.iade.ei.zoopolis.models.AnimalDTO
import pt.iade.ei.zoopolis.models.Person

interface FavoriteRepository {

    suspend fun getFavoriteAnimalsByPerson(personId: Int): Flow<Result<List<AnimalDTO>>>
}