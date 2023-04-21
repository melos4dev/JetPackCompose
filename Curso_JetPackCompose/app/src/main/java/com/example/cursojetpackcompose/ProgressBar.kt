package com.example.cursojetpackcompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
//get y set de value para el rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyProgressBar() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Magenta, strokeWidth = 10.dp)
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 16.dp),
            color = Color.Magenta,
            backgroundColor = Color.Transparent
        )
    }

}


@Composable
fun MyProgressBarAdvance() {
    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Magenta, strokeWidth = 10.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Magenta,
                backgroundColor = Color.Transparent
            )
        }
        Button(onClick = { showLoading = !showLoading }) {

            Text(text = "Cargar perfil")

        }

    }

}

@Composable
fun MyProgressBarSuperAdvance() {
    var progressSatatus by rememberSaveable { mutableStateOf(0f) }

    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressSatatus) //estamos diciendo que esta a la mitad
        // podemos sustituir el circular por una LinearProgressIndicator para que sea la barra

        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { progressSatatus += 0.1f }) {
                Text(text = "Incrementar")
            }

            Button(onClick = { progressSatatus -= 0.1f }) {
                Text(text = "Reducir")

            }
        }
    }
}



@Preview(name = "Ejemplo progressBar", showBackground = true, showSystemUi = true)
@Composable
fun PreviewProgressBar() {
    MyProgressBar()
}

@Preview(name = "Ejemplo progressBar", showBackground = true, showSystemUi = true)
@Composable
fun PreviewProgressBarAdvance() {
    MyProgressBarAdvance()
}

@Preview(name = "Ejemplo progressBar", showBackground = true, showSystemUi = true)
@Composable
fun PreviewProgressBarSuperAdvance() {
    MyProgressBarSuperAdvance()
}