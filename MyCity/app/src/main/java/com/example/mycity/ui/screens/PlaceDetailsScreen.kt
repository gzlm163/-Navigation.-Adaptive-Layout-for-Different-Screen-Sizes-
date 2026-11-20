
package com.example.mycity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalConfiguration
import com.example.mycity.ui.viewmodel.CityViewModel

@Composable
fun PlaceDetailsScreen(
    viewModel: CityViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val place = uiState.selectedPlace
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp

    if (place != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(place.imageRes),
                contentDescription = stringResource(place.nameRes),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(
                        max = if (isLandscape) 140.dp else 240.dp
                    )
            )

            Text(
                text = stringResource(place.nameRes),
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = stringResource(place.descriptionRes),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
