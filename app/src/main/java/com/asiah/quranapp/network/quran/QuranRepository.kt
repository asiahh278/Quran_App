package com.asiah.quranapp.network.quran

import com.asiah.quranapp.network.NetworkBoundResource
import com.asiah.quranapp.network.NetworkResponse
import com.asiah.quranapp.network.Resource
import com.asiah.quranapp.presentation.quran.QuranEdition
import com.asiah.quranapp.presentation.quran.Surah
import com.asiah.quranapp.utils.DataMapper
import kotlinx.coroutines.flow.Flow

class QuranRepository {
    override fun getListSurah(): Flow<Resource<List<Surah>>> {
        return object : NetworkBoundResource<List<Surah>, List<SurahItem>>() {
            override fun fetchFromNetwork(data: List<SurahItem>): Flow<List<Surah>> {
                return DataMapper.mapResponseToDomain(data)
            }
        }

        override suspend fun createCall(): Flow<NetworkResponse<List<SurahItem>>> {
            return remoteDataSource.getListSurah()
        }
    }.asFlow()
}

override fun getDetailSurahWithQuranEditions(number: Int): Flow<Resource<List<QuranEdition>>> {
    return object : NetworkBoundResource<List<QuranEdition>, List<QuranEditionItem>>() {
        override fun fetchFromNetwork(data: List<QuranEditionItem>): Flow<List<QuranEdition>> {
            return DataMapper.mapResponseToDomain(data)
        }

        override suspend fun createCall(): Flow<NetworkResponse<List<QuranEditionItem>>> {
            return remoteDataSource.getDetailSurahWithQuranEditions(number)
        }
    }
}