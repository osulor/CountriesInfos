package com.example.countriesinfos.data

import com.example.countriesinfos.data.model.CountriesItem
import com.example.countriesinfos.remote.RetrofitInstance
import retrofit2.Response

interface CountryRepository {
    suspend fun getCountries() : Response<List<CountriesItem>>{
        return RetrofitInstance().Country_API.getCountries()
    }
}