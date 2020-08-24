package com.example.activityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_edit_text.*
import kotlinx.android.synthetic.main.activity_edit_text.edtEmail
import kotlinx.android.synthetic.main.activity_edit_text.edtName
import kotlinx.android.synthetic.main.activity_edit_text.edtPass
import kotlinx.android.synthetic.main.activity_material_designer.*
import java.util.regex.Pattern

class MaterialDesignerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_designer)

        edtPass.setOnEditorActionListener { view, id, _ ->
            if (view == edtPass && EditorInfo.IME_ACTION_DONE == id) {
                registerUser()
            }
            false
        }
    }

    private fun registerUser() {
        val name = edtName.text.toString()
        val email = edtEmail.text.toString()
        val pass = edtPass.text.toString()
        var isValid = true

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.error = getString(R.string.hint_error_email)
            isValid = false
        } else {
            tilEmail.error = null
        }

        if (pass != "123") {
            tilPass.error = getString(R.string.hint_error_password)
            isValid = false
        } else {
            tilPass.error = null
        }

        if (isValid) {
            showShortToast(getString(R.string.msg_sucess, name, email))
        }
    }
}