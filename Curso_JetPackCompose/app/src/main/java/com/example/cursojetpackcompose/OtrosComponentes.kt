package com.example.cursojetpackcompose

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursojetpackcompose.ui.theme.CursoJetPackComposeTheme

@Preview(name = "Ejemplo Card", showSystemUi = true, showBackground = true)
@Composable
fun PreviewCard() {
    MyCard()
}


@Composable
fun MyCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.LightGray,
        contentColor = Color.DarkGray,
        border = BorderStroke(5.dp, Color.DarkGray)

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")

        }

    }
}

@Preview(name = "Ejemplo surface", showSystemUi = true, showBackground = true)
@Composable
fun PreviewSurface() {
    MySurface()
}

@Composable
fun MySurface() {
    //Lo mismo que las card, le supuesta diferencia es que tienen unaos valores ya definidos
}


/*
@Preview(name = "Ejemplo surface", showSystemUi = true, showBackground = true)
@Composable
fun PreviewBadgeBox() {
    CursoJetPackComposeTheme {
        MyBadgeBox()
    }

}

@OptIn(ExperimentalMaterialApi :: class )
@Composable
fun MyBadgeBox(){
    BadgedBox(modifier = Modifier.padding(16.dp),
        badgeContent = {Text(tex = "2")},
        backgroud =  Color.blue
    contentColor = Color.megenta
    ), {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
        
    }
}
*/

@Preview(name = "Ejemplo divider", showSystemUi = true, showBackground = true)
@Composable
fun PreviewDivider() {
    CursoJetPackComposeTheme() {
        MyDivider()
    }

}

@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 15.dp), color = Color.Magenta
    )
}


@Preview(name = "Ejemplo dropDownMenu", showSystemUi = true, showBackground = true)
@Composable
fun PreviewDropDownMenu() {
    MyDropDownMenu()

}

@Composable
fun MyDropDownMenu() {

    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val fatFood = listOf("Burguer", "pizza", "nutella", "hot dog", "huevos fritos")


    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()

        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            fatFood.forEach { fatFood ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = fatFood
                }) {
                    Text(text = fatFood)
                }
            }
        }
    }
}

























