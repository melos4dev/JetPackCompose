package com.example.cursojetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MyImage() {
    // Pondriamos la id. de la imagen subida a drawable
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejmplo con imagen de resources launcher",
        alpha = 0.5f
    )
    //alpha nos indica la opacidad de la imagen

}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo avanzado",
        modifier = Modifier.clip(CircleShape)

    )
}


@Preview(name = " Ejemplo imagenes circulares", showSystemUi = true, showBackground = true)
@Composable
fun PreviewImagenesCirculares() {
    MyImage()
}

@Preview(name = "Image advance", showSystemUi = true, showBackground = true)
@Composable
fun PreviewImageAdvance() {
    MyImageAdvance()
}