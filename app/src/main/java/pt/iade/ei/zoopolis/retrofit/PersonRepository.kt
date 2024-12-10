package pt.iade.ei.zoopolis.retrofit

import kotlinx.coroutines.flow.Flow
import pt.iade.ei.zoopolis.models.Person

interface PersonRepository {

    suspend fun getPersons(): Flow<Result<List<Person>>>

    suspend fun getPersonsById(id: Int): Flow<Result<Person>>

}