package mx.unam.fi.ejercicio7api.model

import kotlinx.serialization.Serializable

@Serializable
data class EjercicioModel (
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url:String,
    val download_url:String,
    )