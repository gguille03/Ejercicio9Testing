package mx.unam.fi.ejercicio7api.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import mx.unam.fi.ejercicio7api.Ejercicio9PhotoApplication
import mx.unam.fi.ejercicio7api.data.Ejercicio9PhotoRepository
import mx.unam.fi.ejercicio7api.data.NetworkEjercicio9PhotoRepository
import mx.unam.fi.ejercicio7api.model.EjercicioModel

import java.io.IOException

sealed interface  Ejercicio7UiState {
    data class Success(val photos:List<EjercicioModel>): Ejercicio7UiState
    object Error: Ejercicio7UiState
    object Loading: Ejercicio7UiState
}
class Ejercicio7ViewModel(private val ejercicio9PhotoRepository: Ejercicio9PhotoRepository): ViewModel() {
    var ejercicio7UiState: Ejercicio7UiState by mutableStateOf(Ejercicio7UiState.Loading)
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

                val listResult =ejercicio9PhotoRepository.getEjercicio7Photos()
                Ejercicio7UiState.Success(listResult)
            } catch (e: IOException) {
                Ejercicio7UiState.Error
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory= viewModelFactory {
            initializer{
                val application=(this[APPLICATION_KEY]as Ejercicio9PhotoApplication)
                val ejercicio9PhotoRepository=application.container.ejercicio9PhotoRepository
                Ejercicio7ViewModel(ejercicio9PhotoRepository=ejercicio9PhotoRepository)
            }
        }
    }

}