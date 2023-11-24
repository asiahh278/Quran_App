package com.asiah.quranapp.network.adzan

import androidx.lifecycle.LiveData
import com.asiah.quranapp.network.Resource
import kotlinx.coroutines.flow.Flow

interface IAdzanRepository {
    fun getLastKnowLocation(): LiveData<List<String>>
    fun searchCity(city: String): Flow<Resource<List<City>>>

    fun getDailyAdzanTime(
        id: String,
        year: String,
        month: String,
        date: String
    ): Flow<Resource<DailyAdzan>>
}