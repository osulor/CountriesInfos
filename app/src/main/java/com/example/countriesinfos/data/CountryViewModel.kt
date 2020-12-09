package com.example.countriesinfos.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countriesinfos.data.model.CountriesItem

class CountryViewModel(private val countryRepository: CountryRepository): ViewModel() {

     val _countriesList: MutableLiveData<List<CountriesItem>> = MutableLiveData()
    val countriesList : LiveData<List<CountriesItem>>
        get() = _countriesList



}