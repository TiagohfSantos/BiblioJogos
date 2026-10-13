package com.example.bibliojogos.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bibliojogos.navigation.Routes

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Routes.LIST) {

        composable(Routes.LIST) {
            GameListScreen(
                onAddGame = { navController.navigate(Routes.edit()) },
                onGameClick = { id -> navController.navigate(Routes.edit(id)) },
                onOpenStats = { navController.navigate(Routes.STATS) }
            )
        }

        composable(
            route = Routes.EDIT,
            arguments = listOf(navArgument("gameId") { type = NavType.IntType })
        ) {
            GameEditScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(Routes.STATS) {
            StatsScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}