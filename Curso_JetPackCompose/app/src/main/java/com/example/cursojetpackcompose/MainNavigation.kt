package com.example.cursojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cursojetpackcompose.ui.theme.CursoJetPackComposeTheme

class MainNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.route
                    ){
                        composable(Routes.Pantalla1.route){Screen1(navigationController)}
                        composable(Routes.Pantalla2.route){Screen2(navigationController)}
                        composable(Routes.Pantalla3.route){Screen3(navigationController)}
                        composable(Routes.Pantalla4.route,
                            arguments = listOf(navArgument("name"){type = NavType.IntType})
                        ){ backStackEntry ->
                            Screen4(
                                navigationController,
                                (backStackEntry.arguments?.getString("name") ?: 0) as Int
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CursoJetPackComposeTheme {
        Greeting("Android")
    }
}