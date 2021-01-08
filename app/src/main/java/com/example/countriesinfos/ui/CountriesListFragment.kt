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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countriesinfos.data.CountryRepository
import com.example.countriesinfos.data.model.CountriesItem
import com.example.countriesinfos.data.viewmodel.CountryViewModel
import com.example.countriesinfos.data.viewmodel.ViewModelFactory
import com.example.countriesinfos.databinding.FragmentCountriesListBinding
import com.example.countriesinfos.utils.ApiCallState

class CountriesListFragment : Fragment() {

    lateinit var countryViewModel : CountryViewModel
    lateinit var countriesAdapter: CountriesAdapter
    private lateinit var binding: FragmentCountriesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountriesListBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = ViewModelFactory(CountryRepository(activity?.application))

        countryViewModel = ViewModelProvider(this,viewModelFactory).get(CountryViewModel::class.java)

        retrieveData()
        observeData()
    }
    
    private fun retrieveData(){
        if (hasInternetConnection()){
            countryViewModel.getCountries()
        } else {
            Toast.makeText(this.context,"NO INTERNET",Toast.LENGTH_LONG).show()
        }
    }

    private fun displayCountriesInfos(countries: List<CountriesItem>){
        countriesAdapter = CountriesAdapter(countries)

       binding.recyclerView.apply {
            adapter = countriesAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }

    private fun observeData(){
        val apiCallState = countryViewModel.apiCallState.value
        countryViewModel.countriesList.observe(this.viewLifecycleOwner, Observer {countriesList ->
            when (apiCallState) {
                is ApiCallState.Loading -> Toast.makeText(this.context,"Loading State",Toast.LENGTH_LONG).show()
                is ApiCallState.Success -> {
                    Toast.makeText(this.context,"Success the first country is ${countriesList.size}",Toast.LENGTH_LONG).show()
                    displayCountriesInfos(countriesList)
                }
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