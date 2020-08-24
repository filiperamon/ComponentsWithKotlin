package com.example.activityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_components.*

class ComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)
        initSpinner()
        initSeekBar()
        initSwitch()

        //valores parão
        chkEnable.isChecked = true
        skbValue.progress = 20
        spnNames.setSelection(2)
        rgOptions.check(R.id.rbOption2)

        btnShowValues.setOnClickListener {
            showValues()
        }
    }

    private fun initSpinner() {
        val names = arrayOf("Erik", "Diana", "Presto", "Hank", "Sheila", "Bob")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            names
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spnNames.adapter = adapter
    }

    private fun initSeekBar() {
        skbValue.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    txtValue.text = p1.toString()
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {}

                override fun onStopTrackingTouch(p0: SeekBar?) {}

            }
        )
    }

    private fun initSwitch() {
        swtEnabled.setOnCheckedChangeListener { compoundButton, b ->
            chkEnable.isEnabled = compoundButton.isChecked
            tgbEnabled.isEnabled = b
        }
    }

    private fun showValues() {
        val idSelectedRadio = rgOptions.checkedRadioButtonId
        val radio = findViewById<RadioButton>(idSelectedRadio)
        val enabledText = getString(
            if (chkEnable.isChecked)
                R.string.text_enabled
            else
                R.string.text_disable
        )
        val message = getString(
            R.string.msg_result,
            enabledText,
            skbValue.progress,
            spnNames.selectedItem,
            radio.text.toString()
        )

        showShortToast(message)
    }
}