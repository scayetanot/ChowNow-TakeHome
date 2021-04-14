package com.example.chownow.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chownow.BR
import com.example.chownow.R
import com.example.chownow.data.model.RestaurantLocation
import com.example.chownow.databinding.LocationItemBinding

class LocationsListAdapter(
        var listOfLocations: List<RestaurantLocation>,
        var viewModel: LocationsListFragmentViewModel) : RecyclerView.Adapter<LocationsListAdapter.ViewHolder>() {

    private var listViewmodel: LocationsListFragmentViewModel = viewModel

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
        holder.bindViewHolder(position, listOfLocations[position])
    }

    inner class ViewHolder(private val context: Context, private val viewDataBinding: LocationItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bindViewHolder(position: Int, location: RestaurantLocation) {
            viewDataBinding.locationName.text = location.name
            viewDataBinding.setVariable(BR.viewModel, listViewmodel)
            viewDataBinding.setVariable(BR.position, position)
            viewDataBinding.executePendingBindings()
        }
    }

}