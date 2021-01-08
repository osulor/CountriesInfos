package com.example.countriesinfos.data

import android.app.Application
import com.example.countriesinfos.data.model.CountriesItem
import com.example.countriesinfos.db.CountryDAO
import com.example.countriesinfos.db.CountryDatabase
import com.example.countriesinfos.remote.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class CountryRepository(application: Application?) : CountryDAO {


    private lateinit var countryDAO : CountryDAO

    init {
        val db = application?.let { CountryDatabase.getDatabase(it) }
        if (db != null) {
            countryDAO = db.countryDao()
        }
    }


    suspend fun getCountriesFromApi() : Response<List<CountriesItem>>{
        return RetrofitInstance().country_API.getCountries()
    }

    override suspend fun insertCountry(country: CountriesItem) {
        countryDAO.insertCountry(country)
    }

    override suspend fun getCountriesFromDB(): Flow<List<CountriesItem>> {
        return countryDAO.getCountriesFromDB()
    }

}