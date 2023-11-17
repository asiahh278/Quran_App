package com.asiah.quranapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asiah.quranapp.databinding.ItemSurahBinding
import com.asiah.quranapp.network.quran.SurahItem

// TODO 13: SETTING ADAPTER FOR BRIDGE OF DATA
class QuranAdapter: RecyclerView.Adapter<QuranAdapter.SurahViewHolder>() {
    class SurahViewHolder(val binding: ItemSurahBinding) : RecyclerView.ViewHolder(binding.root)

    private val listSurah = ArrayList<SurahItem>()

    fun setData(list: List<SurahItem>?) {
        if (list == null) return
        listSurah.clear()
        listSurah.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    )= SurahViewHolder (
        ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val data = listSurah[position]
        holder.binding.apply {
            tvSurah.text = data.englishName
            val revelationType = data.revelationType
            val numberOfAyahs = data.numberOfAyahs
            val resultOfAyah = "$revelationType - $numberOfAyahs Ayahs"
            tvAyah.text = resultOfAyah
            tvName.text = data.name
            tvNumber.text = data.number.toString()
        }
    }

    override fun getItemCount() = listSurah.size
}