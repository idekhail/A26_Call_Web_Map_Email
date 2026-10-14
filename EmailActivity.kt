package com.b26_b.b26_call_web

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_email)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mail_from = findViewById<EditText>(R.id.mail_from)
        val mail_to = findViewById<EditText>(R.id.mail_to)
        val subject = findViewById<EditText>(R.id.subject)
        val msg = findViewById<EditText>(R.id.msg)
        val send = findViewById<Button>(R.id.send)
        val back = findViewById<Button>(R.id.back)

        send.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.data = Uri.parse("mailto:")
            var to = arrayOf(mail_from.text.toString(), mail_to.text.toString())
            i.putExtra(Intent.EXTRA_EMAIL, to)
            i.putExtra(Intent.EXTRA_SUBJECT, subject.text.toString())
            i.putExtra(Intent.EXTRA_TEXT, msg.text.toString())
            i.type = "massage/rfc822"
            var chosser = Intent.createChooser(i, "Send an Email")

            startActivity(chosser)
        }
        back.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

    }
}