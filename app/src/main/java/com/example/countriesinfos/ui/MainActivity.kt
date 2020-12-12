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

//       val viewModelFactory = ViewModelFactory(CountryRepository())
//
//        countryViewModel = ViewModelProvider(this,viewModelFactory).get(CountryViewModel::class.java)
//        countryViewModel.getCountries()
//
//        countryViewModel.countriesList.observe(this, Observer {apiCallState ->
//
//            when (apiCallState){
//                is ApiCallState.Loading -> Toast.makeText(this,"Loading State",Toast.LENGTH_LONG).show()
//                is ApiCallState.Success -> Toast.makeText(this,"Success the first country is ${apiCallState.data?.get(0)?.name}",Toast.LENGTH_LONG).show()
//                is ApiCallState.Error -> Toast.makeText(this,"${apiCallState.message}",Toast.LENGTH_LONG).show()
//            }
//        })

    }

}