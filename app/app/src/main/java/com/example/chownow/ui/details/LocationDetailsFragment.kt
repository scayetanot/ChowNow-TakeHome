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
import com.example.chownow.BR
import com.example.chownow.MainApplication.Companion.appComponents
import com.example.chownow.R
import com.example.chownow.data.model.RestaurantLocation
import com.example.chownow.databinding.FragmentLocationDetailsBinding
import com.example.chownow.ui.main.MainActivity.Companion.LOCATION_ID
import com.example.chownow.ui.main.MainActivity.Companion.RESTAURANT_ID
import com.example.chownow.utils.formatPhoneNumber
import com.example.chownow.utils.remainingTime
import com.example.chownow.utils.viewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_location_details.view.*
import javax.inject.Inject


class LocationDetailsFragment: Fragment() {

    private lateinit var binding: FragmentLocationDetailsBinding
    private var restaurantId: String? = ""
    private var locationId: String? = ""


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

        //val mapFragment = fragmentManager?.findFragmentById(R.id.map_fragment) as SupportMapFragment
        //if (mapFragment != null) {
        //    mapFragment.getMapAsync(OnMapReadyCallback {
        //        val mMap = it

                // Add a marker in Sydney and move the camera
        //        val sydney = LatLng(-34.0, 151.0)
        //        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        //    })
        //} else {
        //    Toast.makeText(this.context, "Error - Impossible to load Map", Toast.LENGTH_SHORT).show()
        //}

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

                binding.openOrClose.text = if(it.fulfillment.dineIn.isAvailableNow) {
                    getString(R.string.currently_open)
                } else {
                    getString(R.string.currently_close)
                }

                if((it.fulfillment.dineIn.isAvailableNow != null)
                    && it.fulfillment.dineIn.isAvailableNow
                    && !it.fulfillment.dineIn.nextClosedTime.isNullOrEmpty()) {
                    binding.remainingTime.text = remainingTime(it.fulfillment.dineIn.nextClosedTime)
                    binding.remainingTime.visibility = View.VISIBLE
                } else {
                    binding.remainingTime.visibility = View.GONE
                }

                if(!it.cuisines.isNullOrEmpty())
                    binding.typeOfCuisine.text = it.cuisines.joinToString(", ")

                //MAP

                binding.name.text = it.name
                binding.address.text = it.address.formattedAddress
                binding.phone.text = formatPhoneNumber(it.phone)

             //   binding.setVariable(BR.viewModel, listViewmodel)

            }
        }
        )

        getViewModel().errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.context,"Connection Error", Toast.LENGTH_LONG).show();
        })
    }
}