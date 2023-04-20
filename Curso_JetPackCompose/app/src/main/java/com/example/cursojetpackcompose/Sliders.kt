package com.example.cursojetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview


@Preview(name = "Slider basico", showBackground = true, showSystemUi = true)
@Composable
fun PreviewSliderBasic() {
    MySlider()
}

@Composable
fun MySlider(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString() )

    }
}

@Preview(name = "Section Slider", showBackground = true, showSystemUi = true)
@Composable
fun PreviewSliderSection() {
    MySliderSection()
}

@Composable
fun MySliderSection(){

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {completeValue = sliderPosition.toString()},
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = completeValue )
    }

}

@Preview(name = "Section  ranger Slider", showBackground = true, showSystemUi = true)
@Composable
fun PreviewSliderRanger() {
    MySliderRanger()
}

@Composable
fun MySliderRanger(){
    var currentRange by remember{mutableStateOf(0f..10f) }

    RangeSlider(values = currentRange,
        onValueChange = {currentRange = it},
        valueRange = 0f..40f

    )
}










