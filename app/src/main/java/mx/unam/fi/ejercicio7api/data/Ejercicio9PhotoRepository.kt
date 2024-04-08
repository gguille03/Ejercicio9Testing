package mx.unam.fi.ejercicio7api.data

import mx.unam.fi.ejercicio7api.model.EjercicioModel
import mx.unam.fi.ejercicio7api.network.Ejercicio7ApiService


interface Ejercicio9PhotoRepository {
    suspend fun getEjercicio7Photos():List<EjercicioModel>
}
class NetworkEjercicio9PhotoRepository(private val ejercicio7ApiService:Ejercicio7ApiService) :Ejercicio9PhotoRepository{
    private val randomPage = (1..100).random()
    override suspend fun getEjercicio7Photos(): List<EjercicioModel> =ejercicio7ApiService.getPhotos(randomPage,limit=10)
}