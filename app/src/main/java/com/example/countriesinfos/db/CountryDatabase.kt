package com.example.countriesinfos.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.countriesinfos.data.model.CountriesItem


@Database(version = 1, entities = [CountriesItem::class])
abstract class CountryDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDAO

    companion object {
        @Volatile
        private var INSTANCE: CountryDatabase? = null

        fun getDatabase(context: Context) : CountryDatabase {

//            //if the INSTANCE is not null, then return it
//            // if it is, then create the database
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,CountryDatabase::class.java,"countries_db")
                    .build()
                INSTANCE = instance

                //return instance
                instance
            }
        }
    }

}