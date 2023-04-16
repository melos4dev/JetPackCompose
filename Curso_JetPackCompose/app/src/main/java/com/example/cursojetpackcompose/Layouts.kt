package com.example.cursojetpackcompose


import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyColumn() {
    /* Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
         Text("Ejemplo 1", modifier = Modifier.background(Color.Red))
         Text("Ejemplo 2", modifier = Modifier.background(Color.Black))
         Text("Ejemplo 3", modifier =  Modifier.background(Color.Cyan))
         Text("Ejemplo 4", modifier = Modifier.background(Color.Blue))
         Text("Ejemplo 1", modifier = Modifier.background(Color.Red))
         Text("Ejemplo 2", modifier = Modifier.background(Color.Black))
         Text("Ejemplo 3", modifier =  Modifier.background(Color.Cyan))
         Text("Ejemplo 4", modifier = Modifier.background(Color.Blue))
     }
     */

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 2", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 3", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 3", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 4", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 4", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 5", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 5", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 6", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 6", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 7", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 8", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )

    }
}

@Composable
fun Mybox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .width(200.dp)
                .height(200.dp)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Text("   Esto es un ejemplo")
        }

    }
}

@Composable
fun MyRow() {
    /*  Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
          Text(text = "Ejemplo 1")
          Text(text = "Ejemplo 2")
          Text(text = "Ejemplo 3")
      }
       */

    /*
//asi trabajamos con separaciones pero en este caso utilizando los pesos
    Row(Modifier.fillMaxSize() ){
        Text(text = "Ejemplo 4", modifier = Modifier.weight(1f))
        Text(text = "Ejemplo 5",modifier = Modifier.weight(1f) )
        Text(text = "Ejemplo 6", modifier = Modifier.weight(1f))
    }
         */
//Ponemos ancho fijo para que no quepan todos y aniadimos el scroll horizontal
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(text = "Ejemplo 4", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 5", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 6", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 4", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 5", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 6", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 4", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 5", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 6", modifier = Modifier.width(100.dp))
    }


}

@Composable
fun MyComplexlayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Cyan)) {
            
        }
        //no haria falta poner el ancho ni siquiera a o dp porque estamos en una columna --> Spacer(Modifier.height(30.dp)
        //Spacer(Modifier.width(0.dp).height(30.dp))

        //Forma de hacerlo con una funcion que recibirá la altura
        Myspacer(size = 30)

        Row(
            Modifier
                .fillMaxSize()
                .weight(1f)) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red), contentAlignment = Alignment.Center){
                Text(text = "Hola soy Cora")
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Black))
        }

        Myspacer(size = 30)

        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Magenta)) {

        }
    }
}

@Composable
fun Myspacer(size :Int){
    Spacer(Modifier.height(size.dp))
}

@Preview(name = "Combinando layouts", showBackground = true)
@Composable
fun MyPreviewComplexLayout() {
MyComplexlayout()
}


@Preview(name = "Componenetes filas", showBackground = true)
@Composable
fun MyPreviewRow() {
    MyRow()
}


@Preview(name = "Componente Box", showBackground = true)
@Composable
fun MyPreviewBox() {
    Mybox()
}

@Preview(name = "Layout Column ", showBackground = true)
@Composable
fun MyPreviewColumn() {
    MyColumn()
}