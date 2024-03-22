package mx.unam.fi.ejercicio7api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import mx.unam.fi.ejercicio7api.ui.theme.Ejercicio7ApiTheme
import mx.unam.fi.ejercicio7api.ui.theme.Ejercicio7App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio7ApiTheme {
                Ejercicio7App()
            }
        }
    }
}
