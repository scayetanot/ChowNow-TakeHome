package com.example.chownow.ui.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chownow.BR
import com.example.chownow.R
import com.example.chownow.data.model.OpeningHours
import com.example.chownow.data.model.RangeItem
import com.example.chownow.data.model.RestaurantLocation
import com.example.chownow.databinding.LocationItemBinding
import com.example.chownow.databinding.OpeningHoursItemBinding
import com.example.chownow.ui.list.LocationsListAdapter

class OpeningHoursListAdapter(var openingList: List<OpeningHours> ) :
    RecyclerView.Adapter<OpeningHoursListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return openingList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            parent.context,
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.opening_hours_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(openingList[position])
    }

    inner class ViewHolder(private val context: Context, private val viewDataBinding: OpeningHoursItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bindViewHolder(openingTime: OpeningHours) {
            viewDataBinding.dow.text = openingTime.dow + ": " + addRange(openingTime.ranges)
        }

        private fun addRange(listOfRange: List<RangeItem>): String {

            val sb = StringBuilder()
            listOfRange.forEach{
                if(!it.from.isNullOrEmpty() && !it.to.isNullOrEmpty())
                    sb.append(it.from)
                        .append(" - ")
                        .append(it.to)
                        .append("\n")
                else
                    sb.append("--")
            }
            if(listOfRange.size == 1){
                sb.setLength(sb.length - 1)
            }
            return sb.toString()
        }
    }
}