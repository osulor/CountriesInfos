package com.example.countriesinfos.data

import com.example.countriesinfos.data.Currency
import com.example.countriesinfos.data.Language
import com.example.countriesinfos.data.RegionalBloc
import com.example.countriesinfos.data.Translations

data class CountriesItem(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val area: Int,
    val borders: List<Any>,
    val callingCodes: List<String>,
    val capital: String,
    val cioc: String,
    val currencies: List<Currency>,
    val demonym: String,
    val flag: String,
    val gini: Double,
    val languages: List<Language>,
    val latlng: List<Double>,
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int,
    val region: String,
    val regionalBlocs: List<RegionalBloc>,
    val subregion: String,
    val timezones: List<String>,
    val topLevelDomain: List<String>,
    val translations: Translations
)