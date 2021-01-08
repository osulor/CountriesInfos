package com.example.countriesinfos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.countriesinfos.R
import com.example.countriesinfos.data.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {

    lateinit var countryViewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<CountriesListFragment>(R.id.fragment_container)
        }

    }
}