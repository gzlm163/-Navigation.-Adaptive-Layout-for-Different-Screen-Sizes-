
package com.example.mycity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.model.CityCategory
import com.example.mycity.ui.viewmodel.CityViewModel

@Composable
fun CategoriesScreen(
    onCategoryClick: (CityCategory) -> Unit,
    viewModel: CityViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val categories = uiState.categories

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = categories,
            key = { category -> category.name }
        ) { category ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onCategoryClick(category)
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(
                            when (category) {
                                CityCategory.RESTAURANTS -> R.drawable.aviator
                                CityCategory.PARKS -> R.drawable.komsomolsky_park
                                CityCategory.COFFEE_SHOPS -> R.drawable.travelers_coffee
                                CityCategory.CINEMAS -> R.drawable.kosmos
                                CityCategory.SHOPPING_MALLS -> R.drawable.laplandia
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(90.dp)
                    )

                    Text(
                        text = when (category) {
                            CityCategory.RESTAURANTS -> stringResource(R.string.category_restaurants)
                            CityCategory.PARKS -> stringResource(R.string.category_parks)
                            CityCategory.COFFEE_SHOPS -> stringResource(R.string.category_coffee_shops)
                            CityCategory.CINEMAS -> stringResource(R.string.category_cinemas)
                            CityCategory.SHOPPING_MALLS -> stringResource(R.string.category_shopping_malls)
                        },
                        modifier = Modifier.padding(start = 16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}
