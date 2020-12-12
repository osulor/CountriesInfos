package com.example.countriesinfos.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countriesinfos.R
import com.example.countriesinfos.data.CountryRepository
import com.example.countriesinfos.data.viewmodel.CountryViewModel
import com.example.countriesinfos.data.viewmodel.ViewModelFactory
import com.example.countriesinfos.utils.ApiCallState

class CountriesListFragment : Fragment() {


   lateinit var countryViewModel : CountryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_countries_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = ViewModelFactory(CountryRepository())

        countryViewModel = ViewModelProvider(this,viewModelFactory).get(CountryViewModel::class.java)

        if (hasInternetConnection()){
            countryViewModel.getCountries()
        } else {
            Toast.makeText(this.context,"NO INTERNET",Toast.LENGTH_LONG).show()
        }

        val apiCallState = countryViewModel.apiCallState.value

        countryViewModel.countriesList.observe(this.viewLifecycleOwner, Observer {countriesList ->

            when (apiCallState) {
                is ApiCallState.Loading -> Toast.makeText(this.context,"Loading State",Toast.LENGTH_LONG).show()
                is ApiCallState.Success -> Toast.makeText(this.context,"Success the first country is ${countriesList[0].name}",Toast.LENGTH_LONG).show()
                is ApiCallState.Error -> Toast.makeText(this.context,"${apiCallState.message}",Toast.LENGTH_LONG).show()
            }

        })

    }


    private fun hasInternetConnection() : Boolean{

        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)

    }

}