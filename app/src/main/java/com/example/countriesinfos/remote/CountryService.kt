package com.example.countriesinfos.remote

import com.example.countriesinfos.data.model.CountriesItem
import retrofit2.Response
import retrofit2.http.GET

interface CountryService {

    @GET("/all")
    suspend fun getCountries() : Response<List<CountriesItem>>
}