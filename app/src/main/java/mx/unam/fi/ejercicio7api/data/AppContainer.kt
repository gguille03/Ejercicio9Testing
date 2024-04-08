package mx.unam.fi.ejercicio7api.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import mx.unam.fi.ejercicio7api.model.EjercicioModel
import mx.unam.fi.ejercicio7api.network.Ejercicio7ApiService
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val ejercicio9PhotoRepository:Ejercicio9PhotoRepository
}

class DefaultAppContainer:AppContainer{
    private val BASE_URL = "https://picsum.photos"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType() ) )
        .baseUrl(BASE_URL)
        .build()


    private val retrofitService: Ejercicio7ApiService by lazy {
        retrofit.create(Ejercicio7ApiService::class.java)
    }

    suspend fun getRandomPhotos(limit: Int): List<EjercicioModel> {
        val randomPage = (1..100).random() // Genera un número aleatorio entre 1 y 10
        return retrofitService.getPhotos(randomPage, limit)
    }
    /*suspend fun getRandomPhotos(limit: Int): List<EjercicioModel> {
        val randomPage = (1..100).random() // Genera un número aleatorio entre 1 y 10
        return retrofitService.getPhotos(randomPage, limit)
    }*/

    override val ejercicio9PhotoRepository: Ejercicio9PhotoRepository by lazy{
        NetworkEjercicio9PhotoRepository(retrofitService)
    }

}