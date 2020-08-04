package com.example.activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_linkify.*

class ActivityLinkify : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linkify)

        /* Captura evento de addLink por uma intent ActionView */
        if (intent.action == Intent.ACTION_VIEW) {
            val uri = intent.data
            text2.text = uri.toString()
            showShortToast(uri.toString())
        }
    }
}