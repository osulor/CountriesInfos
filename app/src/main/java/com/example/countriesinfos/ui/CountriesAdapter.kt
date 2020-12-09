package com.example.countriesinfos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesinfos.R
import com.example.countriesinfos.data.Countries
import com.example.countriesinfos.data.CountriesItem

class CountriesAdapter(private val countriesList: List<CountriesItem>) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_country_item,parent,false)
        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val country = countriesList.get(position)

        holder.apply {
            country_name.text = country.name
            country_region_name.text = country.region
        }
    }

    override fun getItemCount() = countriesList.size

    inner class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val country_name = itemView.findViewById<TextView>(R.id.country_name)
        val country_flag = itemView.findViewById<ImageView>(R.id.country_flag)
        val country_region_name = itemView.findViewById<TextView>(R.id.country_region_name)

    }
}