package com.example.cursojetpackcompose

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Preview(name = "Ejemplo simple", showBackground = true, showSystemUi = true)
@Composable
fun PreviewReciler() {
    MyRecicler()
}


@Composable
fun MyRecicler() {

    val myList = listOf(" Pepi", "Merche", "Lola")

    LazyColumn {
        item { Text(text = "Holi") }
        items(7) {//este contenido se repetira 7 veces
            Text(text = " Este es el item $it")
        }

        //version de verios items pasando un listado
        items(myList) {
            Text(text = "Hola me llamo $it")
        }

    }

    //Esto mismo podria ser para organizar los items en la pantalla con headers, body y footer
    LazyColumn {

        val myList = listOf(" Pepi", "Merche", "Lola")
        item { Text(text = "Header") }

        //version de verios items pasando un listado
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
        item { Text(text = "Footer") }

    }

}


@Preview(name = "horizontal y vertical", showBackground = true, showSystemUi = true)
@Composable
fun PreviewReciclerHoVe() {
    MyReciclerHoVe()
}

@Composable
fun MyReciclerHoVe() {

    val context = LocalContext.current
    //calmbiando a LazyRow con el arragemente tambien, conseguiriamos desplazamiento en horizontal, sin cambiar nada mas
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero)
            { Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show() }

        }
    }
}

@Preview(name = "grid", showBackground = true, showSystemUi = true)
@Composable
fun PreviewReciclerGrid() {
    MyReciclerGrid()
}

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun MyReciclerGrid() {

    val context = LocalContext.current

    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        //prevalece el tamaño que le damos  en el gridCells a pesar de darle a los items un tamaño fijo (fixed)
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero)
            { Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show() }
        }
    }, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp))
}

@Composable
fun ItemHero(superhero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superhero) }.padding(top = 8.dp, bottom = 8.dp, end = 16.dp, start = 16.dp)) {
        Column() {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )

            Text(
                text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )
        }

    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spider man", "Petter Pan", "Marvel", R.drawable.spiderman),
        SuperHero(" Wolverine", "Logan", " James", R.drawable.logan),
        SuperHero(" Batman", "Bruce wayne", " DC", R.drawable.batman),
        SuperHero("Thor", "Thortito", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrik", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)

    )
}












