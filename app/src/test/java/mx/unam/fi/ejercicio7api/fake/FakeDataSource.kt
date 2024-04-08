package mx.unam.fi.ejercicio7api.fake
import mx.unam.fi.ejercicio7api.model.EjercicioModel

object FakeDataSource {
    const val idOne = "idEjercicio9"
    const val authorOne="César"
    const val widthOne = 225
    const val heightOne = 225
    const val urlOne="url.1"
    const val download_urlOne="Download_url.1"
    const val idTwo = "idEjercicio91"
    const val authorTwo="Guillermo"
    const val widthTwo = 202
    const val heightTwo = 300
    const val urlTwo="url.2"
    const val download_urlTwo="Download_url.1"

    val photoList= listOf(
        EjercicioModel(
            idOne,
            authorOne,
            widthOne,
            heightOne,
            urlOne,
            download_urlOne,
        ),
        EjercicioModel(
            idTwo,
            authorTwo,
            widthTwo,
            heightTwo,
            urlTwo,
            download_urlTwo,
        ),


    )
}