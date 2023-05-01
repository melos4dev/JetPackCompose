package com.example.cursojetpackcompose

//Sealed es unna clase que agrupa varios pequeños objetos
sealed class Routes(val route:String) {

    object Pantalla1 : Routes("pantalla1")
    object Pantalla2 : Routes("pantalla2")
    object Pantalla3 : Routes("pantalla3")
    object Pantalla4 : Routes("pantalla4/{name}"){
        fun createRoute(age:Int) = "pantalla4/$age"
    }
}