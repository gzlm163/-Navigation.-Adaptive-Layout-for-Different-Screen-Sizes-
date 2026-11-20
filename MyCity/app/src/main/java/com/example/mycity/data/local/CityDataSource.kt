package com.example.mycity.data.local

import com.example.mycity.R
import com.example.mycity.data.model.CityCategory
import com.example.mycity.data.model.CityPlace

object CityDataSource {
    val places = listOf(
        CityPlace(1, R.string.place_komsomolsky_park, R.string.description_komsomolsky_park, R.drawable.komsomolsky_park, CityCategory.PARKS),
        CityPlace(2, R.string.place_park_angels, R.string.description_park_angels, R.drawable.park_angels, CityCategory.PARKS),
        CityPlace(3, R.string.place_park_wonders, R.string.description_park_wonders, R.drawable.park_wonders, CityCategory.PARKS),
        CityPlace(4, R.string.place_kosmos, R.string.description_kosmos, R.drawable.kosmos, CityCategory.CINEMAS),
        CityPlace(5, R.string.place_yubileyny, R.string.description_yubileyny, R.drawable.yubileyny, CityCategory.CINEMAS),
        CityPlace(6, R.string.place_greenwich, R.string.description_greenwich, R.drawable.greenwich, CityCategory.CINEMAS),
        CityPlace(7, R.string.place_laplandia, R.string.description_laplandia, R.drawable.laplandia, CityCategory.SHOPPING_MALLS),
        CityPlace(8, R.string.place_ya, R.string.description_ya, R.drawable.ya, CityCategory.SHOPPING_MALLS),
        CityPlace(9, R.string.place_city_park, R.string.description_city_park, R.drawable.city_park, CityCategory.SHOPPING_MALLS),
        CityPlace(10, R.string.place_magic_coffee, R.string.description_magic_coffee, R.drawable.magic_coffee, CityCategory.COFFEE_SHOPS),
        CityPlace(11, R.string.place_travelers_coffee, R.string.description_travelers_coffee, R.drawable.travelers_coffee, CityCategory.COFFEE_SHOPS),
        CityPlace(12, R.string.place_skvorechnik, R.string.description_skvorechnik, R.drawable.skvorechnik, CityCategory.COFFEE_SHOPS),
        CityPlace(13, R.string.place_aviator, R.string.description_aviator, R.drawable.aviator, CityCategory.RESTAURANTS),
        CityPlace(14, R.string.place_provence, R.string.description_provence, R.drawable.provence, CityCategory.RESTAURANTS),
        CityPlace(15, R.string.place_port42, R.string.description_port42, R.drawable.port42, CityCategory.RESTAURANTS)
    )
}