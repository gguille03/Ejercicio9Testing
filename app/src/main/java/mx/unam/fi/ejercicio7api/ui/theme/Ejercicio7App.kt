package mx.unam.fi.ejercicio7api.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.unam.fi.ejercicio7api.R
import mx.unam.fi.ejercicio7api.ui.screens.HomeScreen
import mx.unam.fi.ejercicio7api.viewmodel.Ejercicio7ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ejercicio7App(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { Ejercicio7TopBar(scrollBehavior = scrollBehavior)}
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()) {

            val ejercicio7ViewModel: Ejercicio7ViewModel = viewModel()
            HomeScreen(ejercicio7UiState = ejercicio7ViewModel.ejercicio7UiState, contentPadding = it)

        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ejercicio7TopBar(scrollBehavior: TopAppBarScrollBehavior, modifier:Modifier = Modifier){
    CenterAlignedTopAppBar(
        scrollBehavior=scrollBehavior,
        title = {
            Row (
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.logo_photoroulette),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.headlineMedium
                )
            }

        }
    )

}