package com.example.cursojetpackcompose

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Preview(name = " Alert dialog", showSystemUi = true, showBackground = true)
@Composable
fun PreviewAlertDialof() {
    var show by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar diálogo")
        }
        MyAlertDialog(
            show,
            onDismiss = { show = false },
            onConfirm = { Log.i("Cocomelos", "Click") })
    }
}

@Composable
fun MyAlertDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {

    if (show) {
        //ondismissRequest que pasamos aquí es para cuando el usuario pique fuera del dialog
        AlertDialog(onDismissRequest = {},
            title = { Text(text = "Titulo") },
            text = { Text(text = " Hola soy una descripcion") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")
                }
            }
        )
    }

}


@Preview(name = "dialog personalizado", showSystemUi = true, showBackground = true)
@Composable
fun PreviewDialogPersonal() {
    var show by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar diálogo")
        }
        MyPersonalDialog(show, onDismiss = { show = false })
    }

}


@Composable
fun MyPersonalDialog(show: Boolean, onDismiss: () -> Unit) {

    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo")
                Text(text = "o no")
                Text(text = "o sí")
            }
        }
    }
}


@Preview(name = "dialog super avanzado", showSystemUi = true, showBackground = true)
@Composable
fun PreviewDialogAdvance() {
    var show by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar diálogo")
        }
        MyAdvanceDialog(show, onDismiss = { show = false })
    }
}

@Composable
fun MyAdvanceDialog(show: Boolean, onDismiss: () -> Unit) {

    if (show) {
        Dialog(onDismissRequest = { onDismiss }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(texto = "Set backup acount")
                AccountItem(email = "blablabla@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "blablabla@gmail.com", drawable = R.drawable.pepe)
                AccountItem(email = "Aniadir nueva cuenta", drawable = R.drawable.add)

            }
        }
    }

}

@Composable
//El int del drawable es porque refiere a la direccion de memoria, el @DrawableRest es una
// anotación para asegurarle de que es ese tipo de destino

fun AccountItem(email: String, @DrawableRes drawable: Int) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )

        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))

    }
}

@Composable
fun MyTitleDialog(texto: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {

    Text(
        text = texto,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}


@Preview(name = "dialog de confirmacion", showSystemUi = true, showBackground = true)
@Composable
fun PreviewDialogConfirmation() {

    var show by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar diálogo")
        }
        MyConfirmationDialog(show, onDismiss = { show = false })
    }

}


@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {

    if (show) {

        Dialog(onDismissRequest = { onDismiss }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(texto = "Phone ringthone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), Color.LightGray)

                var status by remember { mutableStateOf("") }
                MyRadioButtonList(status) { status = it }
                Divider(Modifier.fillMaxWidth(), Color.LightGray)
                Row(Modifier.align(Alignment.End).padding(8.dp)) {

                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}





