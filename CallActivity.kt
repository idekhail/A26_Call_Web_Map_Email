package com.a26_a.a26_call_web_map_email

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_call)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mobile = findViewById<EditText>(R.id.mobile)
        val call = findViewById<Button>(R.id.call)
        val web = findViewById<EditText>(R.id.web)
        val open = findViewById<Button>(R.id.open)
        val back = findViewById<Button>(R.id.back)

        call.setOnClickListener {
            val i = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mobile.text.toString().trim()))
            startActivity(i)
        }
        open.setOnClickListener {
            val ic = Intent(Intent.ACTION_VIEW, Uri.parse(web.text.toString().trim()))
            startActivity(ic)
        }

        back.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }
    }
}