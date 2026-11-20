package com.example.mycity.data.repository

import com.example.mycity.data.local.CityDataSource
import com.example.mycity.data.model.CityCategory
import com.example.mycity.data.model.CityPlace

class CityRepository {
    fun getPlaces(): List<CityPlace> {
        return CityDataSource.places
    }

    fun getPlacesByCategory(category: CityCategory): List<CityPlace> {
        return CityDataSource.places.filter { it.category == category }
    }

    fun getPlaceById(id: Int): CityPlace? {
        return CityDataSource.places.find { it.id == id }
    }
}