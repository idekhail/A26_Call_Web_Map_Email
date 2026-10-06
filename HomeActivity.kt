package com.a26_a.a26_call_web_map_email

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val call = findViewById<Button>(R.id.call)
        val map = findViewById<Button>(R.id.map)
        val email2 = findViewById<Button>(R.id.email2)
        val close = findViewById<Button>(R.id.close)

        call.setOnClickListener {
            val ic = Intent(this, CallActivity::class.java)
            startActivity(ic)
        }
        map.setOnClickListener {
            val ic = Intent(this, MapActivity::class.java)
            startActivity(ic)
        }

        email2.setOnClickListener {
            val i = Intent(this, EmailActivity::class.java)
            startActivity(i)
        }

        close.setOnClickListener {
            exitProcess(-1)
        }
    }
}