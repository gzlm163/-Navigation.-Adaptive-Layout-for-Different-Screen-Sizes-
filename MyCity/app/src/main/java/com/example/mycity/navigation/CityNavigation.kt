
package com.example.mycity.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mycity.data.model.CityCategory
import com.example.mycity.ui.screens.CategoriesScreen
import com.example.mycity.ui.screens.AdaptivePlacesScreen
import com.example.mycity.ui.viewmodel.CityViewModel

@Composable
fun CityNavigation(
    navController: NavHostController
) {
    val viewModel: CityViewModel = viewModel()

    NavHost(
        navController = navController,
        modifier = Modifier.fillMaxSize(),
        startDestination = CityScreen.CATEGORIES.name,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(CityScreen.CATEGORIES.name) {
            CategoriesScreen(
                onCategoryClick = { category ->
                    viewModel.selectCategory(category)
                    navController.navigate(
                        "${CityScreen.PLACES.name}/${category.name}"
                    )
                },
                viewModel = viewModel
            )
        }

        composable(
            route = "${CityScreen.PLACES.name}/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("category")
            val category = CityCategory.valueOf(categoryName!!)

            AdaptivePlacesScreen(
                category = category,
                onBackClick = {
                    navController.popBackStack()
                },
                viewModel = viewModel
            )
        }
    }
}
