package com.example.activityresult.cap5.ListviewAdapter.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.StringRes
import com.example.activityresult.R
import com.example.activityresult.cap5.ListviewAdapter.Data.Vehicle
import kotlinx.android.synthetic.main.item_vehicle.view.*

class VehicleAdapter(
    private val context: Context,
    private val vehicles: List<Vehicle>
) : BaseAdapter() {

    private val logos: TypedArray by lazy {
        context.resources.obtainTypedArray(R.array.logos)
    }

    override fun getItem(position: Int): Any = vehicles[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = vehicles.size

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, p1: View?, parent: ViewGroup?): View {
        val vehicle = vehicles[position]
        val row = LayoutInflater.from(context).inflate(R.layout.item_vehicle, parent, false)

        row.imgLogo.setImageDrawable(logos.getDrawable(vehicle.manufacturer))
        row.txtModel.text = vehicle.model
        row.txtYear.text = vehicle.year.toString()
        row.txtGasoline.text = context.getString(getFuel(vehicle))

        return row
    }

    @StringRes
    private fun getFuel(vehicle: Vehicle): Int =
        if (vehicle.gasoline && vehicle.ethanol) R.string.fuel_flex
        else if(vehicle.gasoline) R.string.gasoline
        else if (vehicle.ethanol) R.string.ethanol
        else R.string.fuel_invalid
}