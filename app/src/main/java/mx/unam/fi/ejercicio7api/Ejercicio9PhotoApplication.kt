package mx.unam.fi.ejercicio7api

import android.app.Application
import mx.unam.fi.ejercicio7api.data.AppContainer
import mx.unam.fi.ejercicio7api.data.DefaultAppContainer

class Ejercicio9PhotoApplication:Application (){
    lateinit var container:AppContainer
    override fun onCreate() {
        super.onCreate()
        container=DefaultAppContainer()
    }
}