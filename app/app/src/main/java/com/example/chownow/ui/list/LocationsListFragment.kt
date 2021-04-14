package com.example.chownow.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chownow.MainApplication
import com.example.chownow.R
import com.example.chownow.data.model.RestaurantLocation
import com.example.chownow.databinding.FragmentListLocationsBinding
import com.example.chownow.utils.viewModelProvider
import javax.inject.Inject


class LocationsListFragment: Fragment() {


    private val DEFAULTRESTAURANT: String = "1"

    private lateinit var locationsListAdapter: LocationsListAdapter
    private val appComponents by lazy { MainApplication.appComponents }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private fun getViewModel(): LocationsListFragmentViewModel {
        return viewModelProvider(viewModelFactory)
    }

    private lateinit var binding: FragmentListLocationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        appComponents.inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_locations, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() {
        getViewModel().getLocationsForRestaurant(DEFAULTRESTAURANT)
    }

    private fun initObservers() {
        getViewModel().resultLocations.observe(viewLifecycleOwner, Observer { locationsList ->
            locationsList?.let {
                binding.restaurantName.text = it.name
                initRecycler(it.locations)
                }
            }
        )

        getViewModel().errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.context,"Connection Error", Toast.LENGTH_LONG).show();
        })
    }

    private fun initRecycler(list: List<RestaurantLocation>) {
        if (!list.isNullOrEmpty()) {
            locationsListAdapter = LocationsListAdapter(list)
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = locationsListAdapter
            }
        }
    }

}
