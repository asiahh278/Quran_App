package com.asiah.quranapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.asiah.quranapp.network.di.Injection.provideAdzanRepository
import com.asiah.quranapp.network.di.Injection.provideQuranRepository
import com.asiah.quranapp.presentation.adzan.AdzanViewModel
import com.asiah.quranapp.presentation.quran.QuranViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(val context: Context): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
        modelClass.isAssignableFrom(QuranViewModel::class.java) -> {
            QuranViewModel(provideQuranRepository()) as T
        }
            modelClass.isAssignableFrom(AdzanViewModel::class.java) -> {
                AdzanViewModel(provideAdzanRepository(context)) as T
            }
            else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
    }

}