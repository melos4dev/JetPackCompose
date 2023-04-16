package com.example.cursojetpackcompose

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextExample() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es otro ejemplo", color = Color.Blue)
        Text(text = "Esto es otro ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es otro ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es otro ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es otro ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es otro ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es otro ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        //yambien podemos acceder al fontFamili desde fuera, no teniendo que llamar al textStyle si solo queremos eso,
        // igual que el textDecoration, es como se usrealmente

        Text(text = "Esto es otro ejemplo", fontFamily = FontFamily.Cursive)
        Text(text = "Esto es otro ejemplo", textDecoration = TextDecoration.LineThrough)

        Text(text = "Esto es el tamaño", fontSize = 30.sp)

    }
}

@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })

}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")

            } else {
                "" //momentaneamente ponermos comillas para que no nos marque el error donde iria
                // la acción de la condición

                //con condicion:
                it //si no, le asignas el valor de it
            }
        },
        label = { Text(text = "Introduce tu nombre") })

}

@Composable
fun MyTextFieldOutline() {

    var myText by remember { mutableStateOf("") }
    Column() {
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            Modifier.padding(24.dp),
            label = { Text(text = "Holita") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Blue
            )
        )
    }
}



@Preview(name = "ejemplo 1 Text", showSystemUi = true, showBackground = true)
@Composable
fun PreviewTextExample() {
    TextExample()
}

@Preview(name = "Ejemplo textField", showSystemUi = true, showBackground = true)
@Composable
fun PreviewTextField() {
    MyTextField()
}

@Preview(name = "Ejemplo textField avanzado", showSystemUi = true, showBackground = true)
@Composable
fun PreviewTextFieldAdvance() {
    MyTextFieldAdvance()
}

@Preview(name = "Ejemplo textfield outline ", showSystemUi = true, showBackground = true)
@Composable
fun PreviewTextFieldOutline() {
    MyTextFieldOutline()
}


@Composable
//recime dos parametros: el String(valor que queremos que tenga el text, y la lambda)
fun MyTextFieldStateLess(
    name: String,
    onValueChanged: (String) -> Unit
) { //decimos que recibe una funcion "onVaueChaged y devuelve un String, que será el nuevo valor

    // como era antes --> TextField(value = myText, onValueChange = { myText = it })
    //la nueva sentencia:
    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Preview(name = "Ejemplo con stateLess y lambda", showSystemUi = true, showBackground = true)
@Composable
fun PreviewStateLess() {
    //El estado tiene que etar en el padre o donde se llama a la función para pasarle el valor
    // que queremos que tenga myText
    var myText by remember { mutableStateOf("") }

    MyTextFieldStateLess(myText) { myText = it }
}


