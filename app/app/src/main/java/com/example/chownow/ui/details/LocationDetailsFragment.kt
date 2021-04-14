package com.example.chownow.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.chownow.MainApplication.Companion.appComponents
import com.example.chownow.R
import com.example.chownow.databinding.FragmentLocationDetailsBinding
import com.example.chownow.ui.main.MainActivity.Companion.LOCATION_ID


class LocationDetailsFragment: Fragment() {

    private lateinit var binding: FragmentLocationDetailsBinding
    private var locationId: String? = "0"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        appComponents.inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_location_details, container,false)
        locationId = arguments?.getString(LOCATION_ID)
     //   binding.close.setOnClickListener(){
     //       activity?.onBackPressed();
     //   }

        return binding.root
    }
}