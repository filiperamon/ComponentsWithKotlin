package com.example.activityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_edit_text.*

class EditTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        edtPass.setOnEditorActionListener { view , id, _ ->
            if(view == edtPass && EditorInfo.IME_ACTION_DONE == id){
                registerFunction()
            }
            false
        }
    }

    private fun registerFunction() {
        val name = edtName.text.toString()
        val email = edtEmail.text.toString()
        val pass = edtPass.text.toString()
        var isValid = true

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.error = getString(R.string.hint_error_email)
            isValid = false
        }
        if(pass != "123"){
            edtPass.error = getString(R.string.hint_error_password)
            isValid = false
        }
        if(isValid){
            showShortToast(getString(R.string.msg_sucess, name, email))
        }
    }
}