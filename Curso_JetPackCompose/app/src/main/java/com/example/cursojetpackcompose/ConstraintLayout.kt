package com.example.cursojetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout



@Composable
fun ConstraintLayoutExample() {

    ConstraintLayout(Modifier.fillMaxSize()) {
val(boxRed, boxBlue, boxYellow, boxMagenta, boxGreen) = createRefs()

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(boxRed.end)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(boxRed.top)
                    end.linkTo(boxRed.start)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    bottom.linkTo(boxRed.top)
                    start.linkTo(boxRed.end)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxRed.bottom)
                    end.linkTo(boxRed.start)
                })
    }

}

@Composable
fun ConstraintLayoutAvanzado(){
    ConstraintLayout(Modifier.fillMaxSize()) {

        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGuide)
                    start.linkTo(startGuide)
                })
    }
}

@Composable
fun ConstraintBarrier(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val(boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed,boxGreen)

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(parent.start, margin = 16.dp)

                })

        Box(
            Modifier
                .size(235.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxGreen.bottom)
                    start.linkTo(parent.start, margin = 32.dp)
                })

        Box(
            Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(barrier)
                })

    }

}

@Composable
fun ConstraintCadenas(){
    ConstraintLayout(Modifier.fillMaxSize()) {

        val(boxRed, boxGreen, boxYellow) = createRefs()


        Box(
            Modifier
                .size(75.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(parent.start)
                    end.linkTo(boxRed.start)
                })

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(boxGreen.end)
                    end.linkTo(boxYellow.start)
                })

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(boxRed.end)

                })

        createHorizontalChain(boxRed, boxGreen,boxYellow, chainStyle = ChainStyle.SpreadInside)
    }
}





@Preview(name = "Ejemplo 1", showSystemUi = true, showBackground = true)
@Composable
fun PreviewExample1() {
    ConstraintLayoutExample()
}
@Preview(name = "Ejemplo guides", showSystemUi = true, showBackground = true)
@Composable
fun PreviewExampleAvanzado(){
    ConstraintLayoutAvanzado()
}

@Preview(name = "Ejemplo barrier", showSystemUi = true, showBackground = true)
@Composable
fun PreviewEjemploBarrier(){
    ConstraintBarrier()
}

@Preview (name="Ejemplo cadena", showSystemUi = true, showBackground = true)
@Composable
fun PreviewExampleCadenas(){
    ConstraintCadenas()

}
