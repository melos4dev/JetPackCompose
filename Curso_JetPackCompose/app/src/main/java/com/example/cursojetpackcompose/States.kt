package com.example.cursojetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StateExample() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //rememberSaveable para evitar que al rotar la pantalla no se reinicie la activity.
        //(necesitamos import manual-->getValue y setValue)Tambien cambiamos el = por el by para no tener que poner
        //counter.value y solo counter. tendrá que ser vas en vez de val
        var counter by rememberSaveable {
            mutableStateOf(0)
        }
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter} veces")

    }

}

@Preview(name = "ejemplo 1 state", showSystemUi = true, showBackground = true)
@Composable
fun PreviewStateExample() {
    StateExample()
}