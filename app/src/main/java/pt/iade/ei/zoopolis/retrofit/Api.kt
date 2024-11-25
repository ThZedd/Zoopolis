package pt.iade.ei.zoopolis.retrofit

import pt.iade.ei.zoopolis.models.AnimalDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("animalsDTO")
    suspend fun getAnimals(): List<AnimalDTO>

    @GET("animalsDTO/{id}")
    suspend fun getAnimalsById(@Path("id") id: Int): AnimalDTO

    companion object{

        const val BASE_URL = "http://10.0.2.2:8080/api/"

    }
}