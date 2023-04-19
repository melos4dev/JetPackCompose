package com.example.cursojetpackcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButtonExample() {

    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            //onClick = { Log.i("Cora", "Hola holita") }, esto era al principio
            onClick = { enabled = false },
            enabled = enabled,

            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta, contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")
        }

    }
}

@Composable
fun buttonOutliner() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledBackgroundColor = Color.Red,
                disabledContentColor = Color.Yellow
            )
        ) {
            Text(text = "Hola")
        }

    }
}

@Composable
fun MyTextButton(){
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledBackgroundColor = Color.Red,
                disabledContentColor = Color.Yellow
            )
        ) {
            Text(text = "Hola boton normal")
        }

        TextButton(onClick = { /*TODO*/ }) {
            //Necesita un texto. La diferencia es que cuando se ejecute el borde del botón no se vera,
        // sera un texto clicable
            Text(text = "hola textButton")
            
        }

    }
}




@Preview(name = " ejemplo boton", showSystemUi = true, showBackground = true)
@Composable
fun PreviewButton() {
    MyButtonExample()
}

@Preview(name = " ejemplo boton outliner", showSystemUi = true, showBackground = true)
@Composable
fun PreviewButtonOutliner() {
    buttonOutliner()
}


@Preview(name="ejemplo boton texto", showSystemUi = true, showBackground = true)
@Composable
fun PreviewTextButton(){
    MyTextButton()
}