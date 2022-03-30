package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    private lateinit var msg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        msg = findViewById(R.id.msgTV)
        val fName = intent.getStringExtra("fName")
        val lName = intent.getStringExtra("lName")
        val email = intent.getStringExtra("email")
        msg.text = "Welcome $fName $lName. Your email is $email"

    }
}