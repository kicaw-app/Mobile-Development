package com.satriopndt.kicawcapstone.di

import android.content.Context
import com.satriopndt.kicawcapstone.data.retrofit.ApiConfig
import com.satriopndt.kicawcapstone.data.pref.UserPreferences
import com.satriopndt.kicawcapstone.data.pref.dataStore
import com.satriopndt.kicawcapstone.repository.KicawRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): KicawRepository{
        val pref = UserPreferences.getInsance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return KicawRepository.getInstance(pref, apiService)
    }
}