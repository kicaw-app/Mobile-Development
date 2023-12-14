package com.satriopndt.kicawcapstone.repository

import com.satriopndt.kicawcapstone.model.FakeDataBird
import com.satriopndt.kicawcapstone.model.KicawModel
import com.satriopndt.kicawcapstone.model.OrderBird
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class KicawRepository {

    private val historyBird = mutableListOf<OrderBird>()

    fun getBirdies(): List<KicawModel>{
        return FakeDataBird.dummyBird
    }

    fun getHistory(): List<KicawModel>{
        return FakeDataBird.dummyBird
    }

    fun searchBird(query: String): List<KicawModel>{
        return FakeDataBird.dummyBird.filter {
            it.name.contains(query, ignoreCase = false)
        }
    }

    fun getAll(): Flow<List<OrderBird>>{
        return flowOf(historyBird)
    }

    companion object{
        @Volatile
        private var instance: KicawRepository? = null

        fun getInstance(): KicawRepository =
            instance ?: synchronized(this){
                KicawRepository().apply {
                    instance = this
                }
            }
    }

}