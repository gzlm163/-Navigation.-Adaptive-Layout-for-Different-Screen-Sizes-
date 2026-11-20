
package com.example.mycity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.data.model.CityCategory
import com.example.mycity.data.model.CityPlace
import com.example.mycity.ui.viewmodel.CityViewModel

@Composable
fun PlacesScreen(
    category: CityCategory,
    onPlaceClick: (CityPlace) -> Unit,
    onBackClick: () -> Unit,
    viewModel: CityViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val places = uiState.places

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = places,
            key = { place -> place.id }
        ) { place ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onPlaceClick(place)
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(place.imageRes),
                        contentDescription = stringResource(place.nameRes),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(120.dp)
                            .height(90.dp)
                    )

                    Text(
                        text = stringResource(place.nameRes),
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}
