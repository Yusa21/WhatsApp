package com.example.navegacion.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicajetpackcompose.Screens.ChatScreen
import com.example.practicajetpackcompose.Screens.InicioWhatsapp


@Composable
fun AppNavigation(modifier: Modifier) {
    val navControlador = rememberNavController()
    NavHost(navController = navControlador, startDestination = AppScreen.FirstScreen.route) {
        composable(AppScreen.FirstScreen.route) {
            InicioWhatsapp(modifier, navControlador)
        }
        composable(
            AppScreen.SecondScreen.route + "/{text}/{text2}",
            arguments = listOf(
                navArgument(name = "text") {
                    type = NavType.StringType
                },
                navArgument(name = "text2") {
                    type = NavType.StringType
                })
        ) {
            ChatScreen(
                modifier,
                navControlador,
                it.arguments?.getString("text"),
                it.arguments?.getString("text2")
            )
        }

    }
}