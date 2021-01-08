package com.example.countriesinfos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesinfos.R
import com.example.countriesinfos.data.model.CountriesItem

class CountriesAdapter(private val countriesList: List<CountriesItem>) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_country_item,parent,false)
        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val country = countriesList[position]

        holder.apply {
            countryName.text = country.name
            countryRegionName.text = country.region

//            Glide.with(this.itemView.context)
//                    .load(country.flag)
//                    .placeholder(R.mipmap.ic_launcher_round)
//                    .into(countryFlag)

            itemView.setOnClickListener {
                Toast.makeText(it.context,country.name, Toast.LENGTH_LONG).show()

            }
        }

    }

    override fun getItemCount() = countriesList.size

    inner class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val countryName: TextView = itemView.findViewById(R.id.country_name)
        val countryFlag: ImageView = itemView.findViewById(R.id.country_flag)
        val countryRegionName: TextView = itemView.findViewById(R.id.country_region_name)

        init {
            itemView.setOnClickListener {
                Toast.makeText(this.itemView.context, countryName.text.toString(), Toast.LENGTH_LONG).show()


            }
        }

    }


//    fun setOnItemClickListener(listener : (CountriesItem) -> Unit){
//        onItemClickListener = listener
//    }

}