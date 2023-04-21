package com.example.cursojetpackcompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursojetpackcompose.ui.theme.CheckInfo


@Composable
fun MySwitch() {

    var state by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Magenta,
            uncheckedTrackColor = Color.Magenta,
            uncheckedTrackAlpha = 0.1f,
            checkedThumbColor = Color.Blue,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.1f,
            disabledCheckedTrackColor = Color.Green,
            disabledCheckedThumbColor = Color.Green,
            disabledUncheckedThumbColor = Color.Green,
            disabledUncheckedTrackColor = Color.Green
        )
    )
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            uncheckedColor = Color.Gray,
            checkedColor = Color.Magenta,
            checkmarkColor = Color.Black
        )
    )
}

@Composable
fun MyCheckBoxText() {

    var state by rememberSaveable { mutableStateOf(true) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo box text")

    }
}


@Composable
fun MyCheckBoxStateHoisting() {

    var state by rememberSaveable { mutableStateOf(true) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo box text")

    }
}


@Composable
fun MyCheckBoxStateHoistingComplete(chechInfo: CheckInfo) {

    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = chechInfo.selected,
            onCheckedChange = { chechInfo.onCheckedChange(!chechInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = chechInfo.title)

    }
}

//Tener muchos titulos y meterlos en cada checkInfo propio
@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {

    //map permite recorrer y devolver una lista, el forEach solo recorrer
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}


@Preview(name = "ejemplo Switch", showSystemUi = true, showBackground = true)
@Composable
fun PreviewSwitch() {
    MySwitch()
}


@Preview(name = "Ejemplo checkBox", showBackground = true, showSystemUi = true)
@Composable
fun PreviewCheckBox() {
    MyCheckBox()
}

@Preview(name = "Ejemplo checkBox con texto", showBackground = true, showSystemUi = true)
@Composable
fun PreviewCheckBoxText() {
    Column() {
        MyCheckBoxText()
        MyCheckBoxText()
    }

}



@Preview(name = "Ejemplo checkBox con texto", showBackground = true, showSystemUi = true)
@Composable
fun PreviewCheckBoxStateHoisting() {

    var status by rememberSaveable { mutableStateOf(false) }
    val checkInfo = CheckInfo(
        title = "Ejemplo checINfi",
        selected = status,
        onCheckedChange = { status = it }
    )

    Column {
        MyCheckBoxText()
        MyCheckBoxText()
        MyCheckBoxStateHoistingComplete(checkInfo)
    }
}


@Preview(name = "Ejemplo checkBox varios", showBackground = true, showSystemUi = true)
@Composable
fun PreviewCheckBoxMultiple() {

    val myOptions = getOptions(listOf("Cocomelos", "Sor pepita", "superPene"))

    Column {
        myOptions.forEach{
            MyCheckBoxStateHoistingComplete(it)
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "mimimi", onClick = { onItemSelected("mimimi") })
        Text(text = "mimimi")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "tititi", onClick = { onItemSelected("tititi") })
        Text(text = "tititi")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "tututu", onClick = { onItemSelected("tututu") })
        Text(text = "tututu")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "asi no es", onClick = { onItemSelected("asi no es") })
        Text(text = "asi no es")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "asi tampoco", onClick = { onItemSelected("asi tampoco") })
        Text(text = "asi tampoco")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "asi sí", onClick = { onItemSelected("asi sí") })
        Text(text = "asi sí")
    }

}