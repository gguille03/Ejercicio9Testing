package mx.unam.fi.ejercicio7api.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.unam.fi.ejercicio7api.R
import mx.unam.fi.ejercicio7api.viewmodel.Ejercicio7UiState


@Composable

fun HomeScreen(
    ejercicio7UiState: Ejercicio7UiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when(ejercicio7UiState){
        is Ejercicio7UiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is Ejercicio7UiState.Success -> ResultScreen(photos = ejercicio7UiState.photos, modifier = modifier.fillMaxWidth())
        is Ejercicio7UiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
    }

}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.sin_wifi)
            , contentDescription = "Error")

    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.load)
            , contentDescription = "Cargando")
    }
}


@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(text = photos )
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        // HomeScreen(stringResource(R.string.placeholder_result))
    }

}