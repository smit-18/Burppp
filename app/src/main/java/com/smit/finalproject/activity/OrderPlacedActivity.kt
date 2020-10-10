package com.smit.finalproject.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.smit.finalproject.R

class OrderPlacedActivity : AppCompatActivity() {

lateinit var btnOk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_order)

        btnOk=findViewById(R.id.btnOk)

        btnOk.setOnClickListener {

            val startAct= Intent(this@OrderPlacedActivity,
                MainActivity::class.java)
            startActivity(startAct)
            finish()
        }
    }
}
