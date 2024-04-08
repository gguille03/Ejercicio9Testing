package mx.unam.fi.ejercicio7api.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import mx.unam.fi.ejercicio7api.model.EjercicioModel
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

/*private const val BASE_URL = "https://picsum.photos"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType() ) )
    .baseUrl(BASE_URL)
    .build()
*/
/*interface Ejercicio7ApiService{

    @GET("api/?key=43124689-5af1450e7d1ec416b05ca384e&q&per_page=3")//para que de 10 imagenes-"v2/list?page=2&limit=10https://pixabay.com/api/?key=43124689-5af1450e7d1ec416b05ca384e&q=cat&image_type=photo"
    suspend fun  getPhotos():List<EjercicioModel>
}*/
interface Ejercicio7ApiService {

    @GET("v2/list")
    suspend fun getPhotos(@Query("page") page: Int, @Query("limit") limit: Int): List<EjercicioModel>
}

//PATRON DE DISEÑO Singleton

/*object Ejercicio7Api{
    val retrofitService: Ejercicio7ApiService by lazy{
       retrofit.create(Ejercicio7ApiService::class.java   )
    }
}*/
/*object Ejercicio7Api {
    val retrofitService: Ejercicio7ApiService by lazy {
        retrofit.create(Ejercicio7ApiService::class.java)
    }

    suspend fun getRandomPhotos(limit: Int): List<EjercicioModel> {
        val randomPage = (1..100).random() // Genera un número aleatorio entre 1 y 10
        return retrofitService.getPhotos(randomPage, limit)
    }
}*/