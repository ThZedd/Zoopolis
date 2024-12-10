package pt.iade.ei.zoopolis.retrofit

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import pt.iade.ei.zoopolis.models.Person
import retrofit2.HttpException


class PersonRepositoryImplementation(
    private val api: Api
): PersonRepository  {

        override suspend fun getPersons(): Flow<Result<List<Person>>> {
            return flow {
                val personsFromApi = try {
                    api.getPersons()
                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Result.Error(message = "Erro ao carregar os animais"))
                    return@flow

                } catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Result.Error(message = "Erro ao carregar os animais"))
                    return@flow

                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Result.Error(message = "Erro ao carregar os animais"))
                    return@flow
                }
                emit(Result.Sucess(personsFromApi))
            }

        }
    override suspend fun getPersonsById(id: Int): Flow<Result<Person>> {
        return flow {
            val personsByIdFromApi = try {
                api.getPersonsById(id)

            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Erro ao carregar os animais"))
                return@flow

            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Erro ao carregar os animais"))
                return@flow

            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Erro ao carregar os animais"))
                return@flow
            }
            emit(Result.Sucess(personsByIdFromApi))
        }
    }
}