package com.example.activityresult.cap5.Activity

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activityresult.R
import com.example.activityresult.cap5.Adapter.VehicleAdapter
import com.example.activityresult.cap5.Data.Vehicle
import com.example.activityresult.cap123.showShortToast
import kotlinx.android.synthetic.main.activity_vehicles.*

class VehicleActivity : AppCompatActivity() {

    private lateinit var txtFooter: TextView

    private val vehicles = mutableListOf(
        Vehicle("Gol", 2015, 1, gasoline = true, ethanol = false),
        Vehicle("Onix", 2014, 2, gasoline = true, ethanol = true),
        Vehicle("Uno", 1995, 3, gasoline = false, ethanol = true),
        Vehicle("Ka", 2020, 4, gasoline = true, ethanol = true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles)

        listView.emptyView = findViewById(android.R.id.empty)

        val adapter = VehicleAdapter(this, vehicles)
        listView.adapter = adapter
        initHeaderAndFooter(listView, adapter)

        listView.setOnItemClickListener { parent, _, position, _ ->
            val vehicle = parent.getItemAtPosition(position) as? Vehicle

            if(vehicle != null){
                val (model, year) = vehicle
                showShortToast("$model $year")

                vehicles.remove(vehicle)
                adapter.notifyDataSetChanged()
                txtFooter.resources.getQuantityString(
                    R.plurals.footer_text, adapter.count, adapter.count
                )
            }

        }
    }

    private fun initHeaderAndFooter(listView: ListView, adapter: VehicleAdapter) {
        val padding = 8
        val txtHeader = TextView(this)
        txtHeader.setBackgroundColor(Color.GRAY)
        txtHeader.setTextColor(Color.WHITE)
        txtHeader.setText(R.string.header_text)
        txtHeader.setPadding(padding, padding, 0, padding)
        listView.addHeaderView(txtHeader)

        txtFooter = TextView(this)
        txtFooter.text = resources.getQuantityString(
            R.plurals.footer_text, adapter.count, adapter.count
        )
        txtFooter.setBackgroundColor(Color.LTGRAY)
        txtFooter.gravity = Gravity.END
        txtFooter.setPadding(0, padding, padding, padding)
        listView.addFooterView(txtFooter)
    }
}