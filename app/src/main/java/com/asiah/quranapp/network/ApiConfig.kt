package com.asiah.quranapp.network

import com.asiah.quranapp.network.quran.QuranApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


// TODO 10: MAKE PERMISSION FOR USE API
object ApiConfig {
    private inline fun <reified T> createService(baseUrl: String): T {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(T::class.java)
    }
    val getQuranServices = createService<QuranApiService>("https://api.alquran.cloud/v1/")
}