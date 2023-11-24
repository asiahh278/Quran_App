package com.asiah.quranapp.network.adzan

import com.asiah.quranapp.network.Resource

data class AdzanDataResult(
    val listLocation: List<String>,
    val dailyAdzan: Resource<DailyAdzan>,
    val listCalendar: List<String>
)
