package com.example.countriesinfos.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.countriesinfos.data.model.CountriesItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(country: CountriesItem)

    @Query("SELECT * FROM countries_table")
    suspend fun getCountriesFromDB() : Flow<List<CountriesItem>>

}