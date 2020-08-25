package com.example.activityresult.cap5.ListviewAdapter.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vehicle = vehicles[position]
        val holder: ViewHolder
        val row: View

        if (convertView == null) {
            row = LayoutInflater.from(context).inflate(R.layout.item_vehicle, parent, false)
            holder = ViewHolder(row)
            //grava o holder na tag
            row.tag = holder
        } else {
            row = convertView
            //recupera holder da tag
            holder = convertView.tag as ViewHolder
        }

        holder.imgLogo.setImageDrawable(logos.getDrawable(vehicle.manufacturer))
        holder.txtModel.text = vehicle.model
        holder.txtYear.text = vehicle.year.toString()
        holder.txtFuel.text = context.getString(getFuel(vehicle))

        return row
    }

    @StringRes
    private fun getFuel(vehicle: Vehicle): Int =
        if (vehicle.gasoline && vehicle.ethanol) R.string.fuel_flex
        else if (vehicle.gasoline) R.string.gasoline
        else if (vehicle.ethanol) R.string.ethanol
        else R.string.fuel_invalid

    companion object {
        data class ViewHolder(val view: View) {
            val imgLogo: ImageView = view.imgLogo
            val txtModel: TextView = view.txtModel
            val txtYear: TextView = view.txtYear
            val txtFuel: TextView = view.txtGasoline
        }
    }
}