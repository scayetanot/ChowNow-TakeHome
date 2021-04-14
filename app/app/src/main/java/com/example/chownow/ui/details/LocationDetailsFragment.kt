package com.example.chownow.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chownow.MainApplication.Companion.appComponents
import com.example.chownow.R
import com.example.chownow.data.model.RestaurantLocation
import com.example.chownow.databinding.FragmentLocationDetailsBinding
import com.example.chownow.ui.main.MainActivity.Companion.LOCATION_ID
import com.example.chownow.ui.main.MainActivity.Companion.RESTAURANT_ID
import com.example.chownow.utils.viewModelProvider
import javax.inject.Inject


class LocationDetailsFragment: Fragment() {

    private lateinit var binding: FragmentLocationDetailsBinding
    private var restaurantId: String? = ""
    private var locationId: String? = ""
    private lateinit var locationInformation: RestaurantLocation



    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private fun getViewModel(): LocationDetailsFragmentViewModel {
        return viewModelProvider(viewModelFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        appComponents.inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_location_details, container,false)
        restaurantId = arguments?.getString(RESTAURANT_ID)
        locationId = arguments?.getString(LOCATION_ID)

        binding.backButton.setOnClickListener { activity?.onBackPressed(); }

//        val mapFragment = fragmentManager?.findFragmentById(R.id.map_fragment) as SupportMapFragment
//        if (mapFragment != null) {
//            mapFragment.getMapAsync(OnMapReadyCallback {
                //loadMap(map);
//            })
//        } else {
//            Toast.makeText(this.context, "Error - Impossible to load Map", Toast.LENGTH_SHORT).show()
//        }


     //   binding.close.setOnClickListener(){
     //       activity?.onBackPressed();
     //   }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initObservers()
    }

    private fun initViews(){
        getViewModel().getLocationDetails(restaurantId, locationId)
    }

    private fun initObservers(){
        getViewModel().resultLocations.observe(viewLifecycleOwner, Observer { locationsList ->
            locationsList?.let {
                locationInformation = it
                Log.d("", "")
             //   binding.restaurantName.text = it.name
            }
        }
        )

        getViewModel().errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.context,"Connection Error", Toast.LENGTH_LONG).show();
        })
    }
}