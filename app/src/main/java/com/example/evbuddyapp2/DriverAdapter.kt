package com.example.evbuddyapp2

import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater

class DriverAdapter(private val driverList: List<Driver>) :
    RecyclerView.Adapter<DriverAdapter.DriverViewHolder>() {

    inner class DriverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.driver_names)
        val info: TextView = itemView.findViewById(R.id.driver_info)
        val rating: RatingBar = itemView.findViewById(R.id.driver_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.driver_item, parent, false)
        return DriverViewHolder(view)
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        val driver = driverList[position]
        holder.name.text = driver.name
        holder.info.text = "${driver.distance} • ${driver.eta}"
        holder.rating.rating = driver.rating
    }

    override fun getItemCount(): Int = driverList.size
}