package com.example.countriesinfos.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.countriesinfos.data.CountryRepository

class ViewModelFactory(private val countryRepository: CountryRepository) : ViewModelProvider.Factory {

    @SuppressWarnings("unchecked")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountryViewModel(countryRepository) as T
    }
}