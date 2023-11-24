package com.asiah.quranapp.network.di

import android.content.Context
import com.asiah.quranapp.local.CalendarReferences
import com.asiah.quranapp.local.LocationPreferences
import com.asiah.quranapp.network.ApiConfig
import com.asiah.quranapp.network.RemoteDataSource
import com.asiah.quranapp.network.adzan.AdzanRepository
import com.asiah.quranapp.network.quran.QuranRepository

object Injection {

    private val quranApiService = ApiConfig.getQuranServices
    private val adzanApiService = ApiConfig.getAdzanTimeService
    private val remoteDataSource = RemoteDataSource(quranApiService, adzanApiService)
        fun provideQuranRepository(): QuranRepository {
            return QuranRepository(remoteDataSource)
        }

        fun provideAdzanRepository(context: Context): AdzanRepository {
            val locationPreferences = LocationPreferences(context)
            val calendarPreferences = CalendarReferences()
            return AdzanRepository(
                remoteDataSource,
                locationPreferences,
                calendarPreferences
            )
        }
    }


