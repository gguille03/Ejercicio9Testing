package mx.unam.fi.ejercicio7api.fake

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import mx.unam.fi.ejercicio7api.fake.rules.TestDispatcherRule
import mx.unam.fi.ejercicio7api.viewmodel.Ejercicio7UiState
import mx.unam.fi.ejercicio7api.viewmodel.Ejercicio7ViewModel
import org.junit.Rule
import org.junit.Test

class Ejercicio9ViewModelTest {
@get:Rule
val testDispatcher=TestDispatcherRule()
    @Test
    fun ejercicio9ViewModel_getEjercicio7Photos_verifyEjercicio7UiStateSuccess(){
        runTest {
            val ejercicio7ViewModel=Ejercicio7ViewModel(
                ejercicio9PhotoRepository = FakeNetworkEjercicio9PhotoRepository()
            )
            assertEquals(Ejercicio7UiState.Success(FakeDataSource.photoList),ejercicio7ViewModel.ejercicio7UiState)
        }
    }
}