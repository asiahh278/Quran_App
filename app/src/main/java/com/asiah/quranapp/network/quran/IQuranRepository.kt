package com.asiah.quranapp.network.quran

import com.asiah.quranapp.network.Resource
import com.asiah.quranapp.presentation.quran.QuranEdition
import com.asiah.quranapp.presentation.quran.Surah
import kotlinx.coroutines.flow.Flow

interface IQuranRepository {
    fun getListSurah() : Flow<Resource<List<Surah>>>

    fun getDetailSurahWithQuranEditions(number: Int) : Flow<Resource<List<QuranEdition>>>
}