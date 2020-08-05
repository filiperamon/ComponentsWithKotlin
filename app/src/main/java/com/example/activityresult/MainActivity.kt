package com.example.activityresult

import android.annotation.SuppressLint
import android.graphics.BitmapFactory.*
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.util.Linkify
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.regex.Pattern

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customTxtLinkFy()
        customTxtStrike()
        customTxtHtml()
    }

    @SuppressLint("SetTextI18n")
    private fun customTxtLinkFy() {
        textView.text = "Testando esse CEP 60350-6090"
        val pattern = Pattern.compile("\\d{5}([\\-]\\d{4})?")
        val scheme = "filipe://"

        /* O textView fica em forma de link clicavel disparando uma intent implicida */
        Linkify.addLinks(textView, pattern, scheme)
    }

    private fun customTxtStrike() {
        //Risca o texto
        txtStrike.paintFlags = txtStrike.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    private fun customTxtHtml() {
        val hmlText = """
            <html>
                <body>
                    Html em <b>Negrito</b>, <i>itálico</i> e <u>sublinhado</u><br>
                    Mario: <img src='mario.png' /><br>
                    Ypshi: <img src='yoshi.png' /><br>
                    Um texto depois da imagem
                </body>
            </html>"""

        val imgGetter = Html.ImageGetter {
            try {
                val bpm = decodeStream(assets.open(it))
                val drawable = BitmapDrawable(resources, bpm)
                drawable.setBounds(0,0,bpm.width,bpm.height)
                drawable
            } catch (e:IOException){
                e.printStackTrace()
                null
            }
        }

        txtHtml.text = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(hmlText, Html.FROM_HTML_MODE_COMPACT, imgGetter, null)
        } else {
            Html.fromHtml(hmlText, imgGetter, null)
        }
    }
}