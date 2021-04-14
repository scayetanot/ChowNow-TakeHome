package com.example.chownow.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chownow.MainApplication.Companion.appComponents
import com.example.chownow.R
import com.example.chownow.databinding.FragmentLocationDetailsBinding
import com.example.chownow.ui.list.LocationsListFragmentViewModel
import com.example.chownow.ui.main.MainActivity.Companion.LOCATION_ID
import com.example.chownow.utils.viewModelProvider
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import javax.inject.Inject


class LocationDetailsFragment: Fragment() {

    private lateinit var binding: FragmentLocationDetailsBinding
    private var locationId: String? = "0"

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
        locationId = arguments?.getString(LOCATION_ID)

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
      //  initObservers()
    }

    fun initViews(){
        getViewModel().getLocationDetails(locationId!!)
    }
}