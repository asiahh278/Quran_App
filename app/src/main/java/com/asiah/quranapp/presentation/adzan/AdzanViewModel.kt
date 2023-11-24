package com.asiah.quranapp.presentation.adzan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.asiah.quranapp.network.Resource
import com.asiah.quranapp.network.adzan.AdzanDataResult
import com.asiah.quranapp.network.adzan.AdzanRepository

class AdzanViewModel (
    private val adzanRepository: AdzanRepository
): ViewModel() {
    fun getDailyAdzanTime():
            LiveData<Resource<AdzanDataResult>> = adzanRepository
        .getResultDailyAdzanTime()
}