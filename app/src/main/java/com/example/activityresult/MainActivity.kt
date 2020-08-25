package com.example.activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityresult.cap5.ListviewAdapter.Activity.VehicleActivity
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent:Intent? = null

        btnEditText.setOnClickListener {
            intent = Intent(this, EditTextActivity::class.java)
            startActivity(intent)
        }

        btnTextView.setOnClickListener {
            intent = Intent(this, TextViewActivity::class.java)
            startActivity(intent)
        }

        btnMaterialDesigner.setOnClickListener {
            intent = Intent(this, MaterialDesignerActivity::class.java)
            startActivity(intent)
        }

        btnComponents.setOnClickListener {
            intent = Intent(this, ComponentsActivity::class.java)
            startActivity(intent)
        }

        btnCustonListView.setOnClickListener {
            intent = Intent(this, VehicleActivity::class.java)
            startActivity(intent)
        }
    }
}