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

// TODO 14: MAKE MVP FOR
class QuranViewModel: ViewModel() {
    private var _listSurah = MutableLiveData<SurahResponse>()
    val listSurah get() = _listSurah as LiveData<SurahResponse>

    private var _listAyah = MutableLiveData<AyahResponse>()
    val listAyah get() = _listAyah as LiveData<AyahResponse>

    fun getListSurah() {
        ApiConfig.getQuranServices.getListSurah().enqueue(object : Callback<SurahResponse> {
            override fun onResponse(call: Call<SurahResponse>, response: Response<SurahResponse>) {
                if (response.isSuccessful) {
                    Log.i("QuranViewModel", "onResponse: ${response.body()}")
                    _listSurah.postValue(response.body())
                } else Log.e(
                    "QuranViewModel",
                    "onResponse: Call error with Http status code " + response.code()
                )
            }

            override fun onFailure(call: Call<SurahResponse>, t: Throwable) {
                Log.e("QuranViewModel", "onFailure: " + t.localizedMessage)
            }
        })

    }

    fun getListAyah(number: Int) {
        ApiConfig.getQuranServices.getListAyahBySurah(number).enqueue(object :
        Callback<AyahResponse> {
            override fun onResponse(
                call: Call<AyahResponse>,
                response: Response<AyahResponse>
            ) {
                if (response.isSuccessful) {
                    Log.i("QuranViewModel", "onResponse: ${response.body()}")
                    _listAyah.value = response.body()
                } else Log.e(
                    "QuranViewModel",
                    "onResponse = Call error with Http status code " + response.code()
                )


            }

            override fun onFailure(call: Call<AyahResponse>, t: Throwable) {
                Log.e("QuranViewModel", "onFailure" + t.localizedMessage)
            }
        })
    }
}