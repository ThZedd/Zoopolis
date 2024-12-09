package pt.iade.ei.zoopolis.retrofit

import pt.iade.ei.zoopolis.models.AnimalDTO
import pt.iade.ei.zoopolis.models.Person
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("animalsDTO")
    suspend fun getAnimals(): List<AnimalDTO>

    @GET("animalsDTO/{id}")
    suspend fun getAnimalsById(@Path("id") id: Int): AnimalDTO

    @GET("persons")
    suspend fun getPersons(): List<Person>

    @GET("persons/{id}")
    suspend fun getPersonsById(@Path("id") id: Int): Person

    companion object{

        const val BASE_URL = "http://10.0.2.2:8080/api/"

    }
}