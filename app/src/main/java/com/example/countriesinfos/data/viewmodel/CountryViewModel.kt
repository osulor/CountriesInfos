package com.example.countriesinfos.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesinfos.data.CountryRepository
import com.example.countriesinfos.data.model.CountriesItem
import com.example.countriesinfos.utils.ApiCallState
import kotlinx.coroutines.launch

class CountryViewModel(private val countryRepository: CountryRepository): ViewModel() {
    
    private val _apiCallState: MutableLiveData<ApiCallState<List<CountriesItem>>> = MutableLiveData()
    val apiCallState: LiveData<ApiCallState<List<CountriesItem>>>
        get() = _apiCallState

    private val _countriesList: MutableLiveData<List<CountriesItem>> = MutableLiveData()
    val countriesList: LiveData<List<CountriesItem>>
        get() = _countriesList

     fun getCountries(){

        // _apiCallState.value = ApiCallState.Loading()

         _apiCallState.value = ApiCallState.Success()


         viewModelScope.launch {

            val response = countryRepository.getCountries()

            if (response.isSuccessful) {

                response.body()?.let {responseBody ->
                    _countriesList.value = responseBody

                }
            } else {
                _apiCallState.value = ApiCallState.Error(response.message())
            }
        }

     }
  
}