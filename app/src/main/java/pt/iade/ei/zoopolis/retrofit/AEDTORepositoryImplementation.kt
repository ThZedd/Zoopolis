package pt.iade.ei.zoopolis.retrofit

import pt.iade.ei.zoopolis.models.AEDTO
import retrofit2.HttpException
import java.io.IOException

class AEDTORepositoryImplementation(private val api: Api) : AEDTORepository {

    override suspend fun getAllAE(): Result<List<AEDTO>> {
        return try {
            val response = api.getAllAE()
            Result.Sucess(response)
        } catch (e: IOException) {
            Result.Error(message = "Error fetching AE records: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error fetching AE records: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }

    override suspend fun getAEById(id: Int): Result<AEDTO> {
        return try {
            val response = api.getAEById(id)
            Result.Sucess(response)
        } catch (e: IOException) {
            Result.Error(message = "Error fetching AE record by ID: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error fetching AE record by ID: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }

    override suspend fun getAEByAnimalId(animalId: Int): Result<List<AEDTO>> {
        return try {
            val response = api.getAEByAnimalId(animalId)
            Result.Sucess(response)
        } catch (e: IOException) {
            Result.Error(message = "Erro ao buscar registros: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "Erro de HTTP: ${e.message()}")
        }
    }

}
