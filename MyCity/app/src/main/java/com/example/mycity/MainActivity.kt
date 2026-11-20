
package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.local.CityDataSource
import com.example.mycity.navigation.CityNavigation
import com.example.mycity.navigation.CityScreen
import com.example.mycity.ui.theme.MyCityTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCityTheme {
                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val title = when {
                    currentRoute == CityScreen.CATEGORIES.name -> "My City"

                    currentRoute?.startsWith("${CityScreen.PLACES.name}/") == true -> {
                        val categoryName = navBackStackEntry?.arguments?.getString("category")
                        when (categoryName) {
                            "RESTAURANTS" -> "Рестораны"
                            "PARKS" -> "Парки"
                            "COFFEE_SHOPS" -> "Кофейни"
                            "CINEMAS" -> "Кинотеатры"
                            "SHOPPING_MALLS" -> "Торговые центры"
                            else -> "My City"
                        }
                    }

                    currentRoute?.startsWith("${CityScreen.PLACE_DETAILS.name}/") == true -> {
                        val placeId = navBackStackEntry?.arguments?.getInt("placeId")
                        val place = placeId?.let { id ->
                            CityDataSource.places.find { it.id == id }
                        }
                        place?.let { getString(it.nameRes) } ?: "My City"
                    }

                    else -> "My City"
                }

                val canNavigateBack = currentRoute != CityScreen.CATEGORIES.name

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = title)
                            },
                            navigationIcon = {
                                if (canNavigateBack) {
                                    IconButton(
                                        onClick = {
                                            navController.popBackStack()
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = "Назад"
                                        )
                                    }
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        CityNavigation(navController = navController)
                    }
                }
            }
        }
    }
}
