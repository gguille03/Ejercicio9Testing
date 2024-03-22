package mx.unam.fi.ejercicio7api.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import mx.unam.fi.ejercicio7api.model.EjercicioModel
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
private const val BASE_URL =  "https://picsum.photos"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType() ) )
    .baseUrl(BASE_URL)
    .build()

interface Ejercicio7ApiService{
    @GET("v2/list?page=1&limit=5")//para que de 10 imagenes
    suspend fun  getPhotos():List<EjercicioModel>
}
//PATRON DE DISEÑO Singleton

object Ejercicio7Api{
    val retrofitService: Ejercicio7ApiService by lazy{
       retrofit.create(Ejercicio7ApiService::class.java   )
    }
}