package com.example.cursojetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorderPurple500
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


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
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)

    )
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.StarHalf,
        contentDescription = "Icono",
        tint = Color.Red

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

@Preview(name = "Ejemplo Iconos", showSystemUi = true, showBackground = true)
@Composable
fun PreviewImageIcon() {
    MyIcon()
}