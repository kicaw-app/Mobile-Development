package com.satriopndt.kicawcapstone.di

import com.satriopndt.kicawcapstone.repository.KicawRepository

object Injection {
    fun provideRepository(): KicawRepository{
        return KicawRepository.getInstance()
    }
}