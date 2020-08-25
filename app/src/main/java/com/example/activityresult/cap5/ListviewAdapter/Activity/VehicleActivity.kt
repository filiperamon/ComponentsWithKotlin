package com.example.activityresult.cap5.ListviewAdapter.Activity

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.activityresult.cap5.ListviewAdapter.Adapter.VehicleAdapter
import com.example.activityresult.cap5.ListviewAdapter.Data.Vehicle

class VehicleActivity: AppCompatActivity() {

    private val vehicles = mutableListOf<Vehicle>(
        Vehicle("Gol", 2015, 1, true, false),
        Vehicle("Onix", 2014, 2, true, true),
        Vehicle("Uno", 1995, 3, false, true),
        Vehicle("Ka", 2020, 4, true, true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val adapter = VehicleAdapter(this, vehicles)
        listView.adapter = adapter
    }
}