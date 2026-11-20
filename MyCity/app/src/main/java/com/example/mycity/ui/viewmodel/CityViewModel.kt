
package com.example.mycity.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycity.data.model.CityCategory
import com.example.mycity.data.model.CityPlace
import com.example.mycity.data.repository.CityRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityViewModel : ViewModel() {

    private val repository = CityRepository()

    private val _uiState = MutableStateFlow(CityUiState())
    val uiState: StateFlow<CityUiState> = _uiState.asStateFlow()

    fun selectCategory(category: CityCategory) {
        _uiState.value = _uiState.value.copy(
            places = repository.getPlacesByCategory(category),
            selectedCategory = category,
            selectedPlace = null
        )
    }

    fun selectPlace(id: Int) {
        val place = repository.getPlaceById(id)

        _uiState.value = _uiState.value.copy(
            selectedPlace = place
        )
    }

    fun clearSelectedPlace() {
        _uiState.value = _uiState.value.copy(
            selectedPlace = null
        )
    }

    fun clearSelection() {
        _uiState.value = CityUiState()
    }

    fun getPlaces(): List<CityPlace> {
        return repository.getPlaces()
    }

    fun getPlacesByCategory(category: CityCategory): List<CityPlace> {
        return repository.getPlacesByCategory(category)
    }

    fun getPlaceById(id: Int): CityPlace? {
        return repository.getPlaceById(id)
    }

    fun getCategories(): List<CityCategory> {
        return _uiState.value.categories
    }
}
