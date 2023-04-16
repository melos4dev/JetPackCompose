package com.example.ejercico1_filascolumnasycajas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Ejercicio(){
   Column(Modifier.fillMaxSize()) {
       Box(
           Modifier
               .fillMaxSize()
               .weight(1f)
               .background(Color.Cyan), Alignment.Center){
           Text(text = "Ejemplo 1")
       }
       Row(
           Modifier
               .fillMaxSize()
               .weight(1f)) {
           Box(
               Modifier
                   .fillMaxSize()
                   .fillMaxHeight()
                   .weight(1f)
                   .background(Color.Red), Alignment.Center){
               Text(text = "Ejemplo 2")
           }
           Box(
               Modifier
                   .fillMaxSize()
                   .fillMaxHeight()
                   .weight(1f)
                   .background(Color.Green), Alignment.Center){
               Text(text = "Ejemplo 3")
           }
           
       }
       Box(
           Modifier
               .fillMaxSize()
               .weight(1f)
               .background(Color.Magenta), Alignment.BottomCenter){
           Text(text = "Ejemplo 4")
       }
   }

}




@Preview(name="Ejercicio filas, cajas y columnas", showBackground = true)
@Composable
fun MyEjercicio(){
    Ejercicio()
}