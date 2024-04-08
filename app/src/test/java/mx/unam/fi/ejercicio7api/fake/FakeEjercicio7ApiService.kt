package mx.unam.fi.ejercicio7api.fake

import mx.unam.fi.ejercicio7api.model.EjercicioModel
import mx.unam.fi.ejercicio7api.network.Ejercicio7ApiService
import retrofit2.http.Query

class FakeEjercicio7ApiService:Ejercicio7ApiService {
    override suspend fun getPhotos(
        @Query(value = "page") page: Int,
        @Query(value = "limit") limit: Int
    ): List<EjercicioModel> {
        return FakeDataSource.photoList
    }
}