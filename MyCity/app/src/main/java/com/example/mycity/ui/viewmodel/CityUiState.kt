package com.example.mycity.ui.viewmodel

import com.example.mycity.data.model.CityCategory
import com.example.mycity.data.model.CityPlace

data class CityUiState(
    val categories: List<CityCategory> = CityCategory.entries,
    val places: List<CityPlace> = emptyList(),
    val selectedCategory: CityCategory? = null,
    val selectedPlace: CityPlace? = null
)
