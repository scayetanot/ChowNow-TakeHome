package com.example.chownow.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chownow.R
import com.example.chownow.data.model.RestaurantLocation
import com.example.chownow.databinding.LocationItemBinding

class LocationsListAdapter(
    var listOfLocations: List<RestaurantLocation>) : RecyclerView.Adapter<LocationsListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return listOfLocations.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsListAdapter.ViewHolder {
        return ViewHolder(
            parent.context,
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.location_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(listOfLocations[position])
    }

    inner class ViewHolder(private val context: Context, private val viewDataBinding: LocationItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bindViewHolder(location: RestaurantLocation) {
            viewDataBinding.locationName.text = location.name
        }
    }

}