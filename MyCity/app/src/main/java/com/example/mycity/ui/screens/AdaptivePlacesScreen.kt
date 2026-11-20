package com.example.mycity.ui.screens

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.example.mycity.data.model.CityCategory
import com.example.mycity.ui.viewmodel.CityViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun AdaptivePlacesScreen(
    category: CityCategory,
    onBackClick: () -> Unit,
    viewModel: CityViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    val navigator = rememberListDetailPaneScaffoldNavigator<Int>()
    val coroutineScope = rememberCoroutineScope()

    NavigableListDetailPaneScaffold(
        navigator = navigator,
        listPane = {
            PlacesScreen(
                category = category,
                onPlaceClick = { place ->
                    viewModel.selectPlace(place.id)

                    coroutineScope.launch {
                        navigator.navigateTo(
                            pane = ListDetailPaneScaffoldRole.Detail,
                            contentKey = place.id
                        )
                    }
                },
                onBackClick = onBackClick,
                viewModel = viewModel
            )
        },
        detailPane = {
            if (uiState.selectedPlace != null) {
                PlaceDetailsScreen(
                    viewModel = viewModel
                )
            }
        }
    )
}
