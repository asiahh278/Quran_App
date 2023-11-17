package com.asiah.quranapp.presentation.quran

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.asiah.quranapp.adapter.SurahAdapter
import com.asiah.quranapp.databinding.ActivityDetailSurahBinding
import com.asiah.quranapp.network.quran.SurahItem

// TODO 16: MAKE MVVM (Model-View-ViewModel) FOR DETAIL
class DetailSurahActivity : AppCompatActivity() {
    private var _binding: ActivityDetailSurahBinding? = null

    private val binding get() = _binding as ActivityDetailSurahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailSurahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra(EXTRA_DATA, SurahItem::class.java)

        val quranViewModel = ViewModelProvider(this)[QuranViewModel::class.java]
        data?.number?.let { quranViewModel.getListAyah(it) }

        binding.apply {
            val relevationType = data?.revelationType
            val numberOfAyahs = data?.numberOfAyahs
            val resultOfAyah = "$relevationType - $numberOfAyahs Ayahs"

            tvDetailSurah.text = resultOfAyah
            tvDetailName.text = data?.name
            tvDetailSurah.text = data?.englishName
            tvDetailNameTranslation.text = data?.englishNameTranslation
        }

        quranViewModel.listAyah.observe(this) {
            binding.rvSurah.apply {
                val mAdapter = SurahAdapter()
                mAdapter.setData(it.quranEdition?.get(0)?.listAyahs, it.quranEdition)
                adapter = mAdapter
                layoutManager = LinearLayoutManager(this@DetailSurahActivity)
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "number"
    }
}