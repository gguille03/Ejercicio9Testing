package mx.unam.fi.ejercicio7api.fake

import mx.unam.fi.ejercicio7api.data.Ejercicio9PhotoRepository
import mx.unam.fi.ejercicio7api.model.EjercicioModel

class FakeNetworkEjercicio9PhotoRepository:Ejercicio9PhotoRepository {
    override suspend fun getEjercicio7Photos():List<EjercicioModel>{
        return FakeDataSource.photoList
    }
}