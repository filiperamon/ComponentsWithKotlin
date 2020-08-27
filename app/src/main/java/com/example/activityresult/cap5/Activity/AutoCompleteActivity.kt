package com.example.activityresult.cap5.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import com.example.activityresult.R
import com.example.activityresult.cap5.Adapter.CitySearchAdapter
import kotlinx.android.synthetic.main.activity_auto_complete.*

class AutoCompleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete)

        val listCitys = listOf<String>(
            "Fortaleza",
            "Recide",
            "Joinville",
            "São Paulo"
        )

        val adapter = CitySearchAdapter(this, android.R.layout.simple_dropdown_item_1line, listCitys)
        acCities.setAdapter(adapter)
    }
}