package com.asiah.quranapp.presentation.quran

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.asiah.quranapp.network.quran.QuranRepository

// TODO 14: MAKE MVVM FOR BRIDGE OF BUSINESS LOGIC & UI
class QuranViewModel(private val quranRepository: QuranRepository): ViewModel() {
 fun getListSurah() =
     quranRepository
         .getListSurah()
         .asLiveData()

    fun getDetailSurahWithQuranEdition(number: Int) =
        quranRepository
            .getDetailSurahWithQuranEditions(number)
            .asLiveData()
}