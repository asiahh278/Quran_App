package com.asiah.quranapp.presentation.quran

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Surah(
    val number: Int? = null,
    val name: String? = null,
    val englishName: String? = null,
    val englishNameTranslation: String? = null,
    val numberOfAyah: Int? = null,
    val revelationType: String? = null
) : Parcelable
