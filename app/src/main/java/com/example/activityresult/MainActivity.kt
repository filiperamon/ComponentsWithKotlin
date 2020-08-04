package com.example.activityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.util.Linkify
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "Testando esse CEP 60350-6090"
        val pattern = Pattern.compile("\\d{5}([\\-]\\d{4})?")
        val scheme = "filipe://"

        /* O textView fica em forma de link clicavel disparando uma intent implicida */
        Linkify.addLinks(textView, pattern, scheme)
    }
}