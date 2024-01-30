package com.llsdc.funfacts.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llsdc.funfacts.ui.UserInputViewModel

@Composable
fun FunFactsNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.USER_INPUT_SCREEN
    ) {

        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(userInputViewModel, showWelcomeScreen = {
                println("Coming_inside_showWelcomeScreen")
                println(it.first)
                println(it.second)
                navController.navigate("$Routes.WELCOME_SCREEN/${it.first}/${it.second}")

            })
        }
        composable("$Routes.WELCOME_SCREEN/{${Routes.USER_NAME}}/{${Routes.CARD_SELECTED}}") { navBackStackEntry ->
            val username = navBackStackEntry.arguments?.getString(Routes.USER_NAME)
            val cardSelected = navBackStackEntry.arguments?.getString(Routes.CARD_SELECTED)
            WelcomeScreen(username, cardSelected)
        }
    }
}