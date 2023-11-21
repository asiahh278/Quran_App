package com.asiah.quranapp.network.quran

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// TODO 11: FOR CALL DATA FROM API (ApiService)
interface QuranApiService {
    @GET("surah")
    suspend fun getListSurah(): SurahResponse

    @GET("surah/{number}/editions/quran-uthmani,ar.alafasy,id.indonesian")
    suspend fun getDetailSurahWithQuranEditions(
        @Path("number") numberSurah: Int
    ): AyahResponse


}