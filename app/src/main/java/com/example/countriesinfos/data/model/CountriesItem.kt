package com.example.countriesinfos.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "countries_table")
data class CountriesItem(
    @PrimaryKey
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "region")val region: String
//    @ColumnInfo(name = "flag")val flag: String,
//    @Embedded
//    @ColumnInfo(name = "language")val language: Language,
//    @Embedded
//    @ColumnInfo(name = "currency")val currency: Currency
)