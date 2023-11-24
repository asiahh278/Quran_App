package com.asiah.quranapp.presentation.quran

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asiah.quranapp.network.ApiConfig
import com.asiah.quranapp.network.quran.AyahResponse
import com.asiah.quranapp.network.quran.SurahResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO 14: MAKE MVVM FOR BRIDGE OF BUSINESS LOGIC & UI
class QuranViewModel: ViewModel() {
 fun getListSurah() =
     quranRepository
         .getListSurah
         .asLiveData()

    fun getDetailSurahWithQuranEdition(number: Int) =
        quranRepository
            .getDetailSurahWithQuranEditions(number)
            .asLiveData()
}