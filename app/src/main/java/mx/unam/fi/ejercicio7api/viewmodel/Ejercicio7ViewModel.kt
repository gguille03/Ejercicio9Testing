package mx.unam.fi.ejercicio7api.viewmodel

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.unam.fi.ejercicio7api.model.EjercicioModel
import mx.unam.fi.ejercicio7api.network.Ejercicio7Api
import java.io.IOException

sealed interface  Ejercicio7UiState {
    data class Success(val photos:List<EjercicioModel>):Ejercicio7UiState
    object Error: Ejercicio7UiState
    object Loading: Ejercicio7UiState
}
class Ejercicio7ViewModel: ViewModel() {
    var ejercicio7UiState:Ejercicio7UiState by mutableStateOf(Ejercicio7UiState.Loading)
        private set
    init{
        getEjercicio7Photos()
    }
    /*private fun getEjercicio7Photos(){
        viewModelScope.launch {
            ejercicio7UiState = try{
                val listResult = Ejercicio7Api.retrofitService.getPhotos()
                Ejercicio7UiState.Success(listResult)

            }
            catch (e: IOException){
                Ejercicio7UiState.Error
            }

        }
    }*/
    private fun getEjercicio7Photos() {
        viewModelScope.launch {
            ejercicio7UiState = try {
                val randomPage = (1..10).random() // Generar un número aleatorio entre 1 y 10
                val limit = 10 // Especificar el límite de imágenes
                val listResult = Ejercicio7Api.retrofitService.getPhotos(randomPage, limit)
                Ejercicio7UiState.Success(listResult)
            } catch (e: IOException) {
                Ejercicio7UiState.Error
            }
        }
    }

}