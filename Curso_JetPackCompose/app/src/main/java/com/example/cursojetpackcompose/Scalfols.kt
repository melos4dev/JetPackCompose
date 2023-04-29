package com.example.cursojetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview(name = "escafol basic", showSystemUi = true, showBackground = true)
@Composable
fun PreviewScaffol() {
    MyScaffol()
}

//Es como un contenedor basicamente
@Composable
fun MyScaffol() {
    val scafoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopApBar (onClickIcon = {
                coroutineScope.launch {
                    scafoldState.snackbarHostState.showSnackbar(
                        "Has pulsado $it"
                    )
                }
            }, onClickDrawer = {coroutineScope.launch { scafoldState.drawerState.open() }})
        },
        scaffoldState = scafoldState,
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFab() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
                // lo ponemos para que se meta en la bottonbar, si no lo ponemos no no se metera dentro o bien ponerlo a false
        drawerContent = { MyDrawer(){coroutineScope.launch { scafoldState.drawerState.close() }} },
        drawerGesturesEnabled = false
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) { /* ... */ }
    }
}

@Composable
fun MyTopApBar(onClickIcon: (String) -> Unit, onClickDrawer:() -> Unit) {
    TopAppBar(
        title = { Text(text = "Mi primera toolBar") },
        backgroundColor = Color.LightGray,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer()}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }

            IconButton(onClick = { onClickIcon("Peligro!!") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Dangerous")
            }
        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }

    BottomNavigation(backgroundColor = Color.Magenta, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home"
            )
        }, label = { Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Fav"
            )
        }, label = { Text(text = "Fav") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person"
            )
        }, label = { Text(text = "Person") })
    }
}

@Composable
fun MyFab() {
    FloatingActionButton(
        onClick = { },
        backgroundColor = Color.LightGray,
        contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun MyDrawer(onClickDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(text = "Primera opcion", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp).clickable { onClickDrawer() }
        )
        Text(text = "segunda opcion", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp).clickable { onClickDrawer() }
        )
        Text(text = "tercera opcion", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp).clickable { onClickDrawer() }
        )
        Text(text = "cuarta opcion", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp).clickable { onClickDrawer() }
        )
    }
}

















