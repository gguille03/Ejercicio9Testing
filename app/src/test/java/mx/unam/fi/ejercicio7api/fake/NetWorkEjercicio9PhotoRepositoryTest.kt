package mx.unam.fi.ejercicio7api.fake

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import mx.unam.fi.ejercicio7api.data.NetworkEjercicio9PhotoRepository
import org.junit.Test

class NetWorkEjercicio9PhotoRepositoryTest {
    @Test
    fun networkCatPhotoRepository_getEjercicio7Photos_verifyPhotoList(){
        runTest {
            val repository = NetworkEjercicio9PhotoRepository(
                ejercicio7ApiService = FakeEjercicio7ApiService()
            )
            assertEquals(FakeDataSource.photoList,repository.getEjercicio7Photos())

        }


    }

}