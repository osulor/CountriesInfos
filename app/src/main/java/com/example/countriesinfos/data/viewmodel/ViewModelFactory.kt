package com.example.countriesinfos.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.countriesinfos.data.CountryRepository

class ViewModelFactory(private val countryRepository: CountryRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CountryViewModel::class.java)){
            return CountryViewModel(countryRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}