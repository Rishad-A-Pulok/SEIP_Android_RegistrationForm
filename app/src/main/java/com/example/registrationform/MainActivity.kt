package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var fnameET: EditText
    private lateinit var lNameET: EditText
    private lateinit var emailET: EditText
    private lateinit var passET: EditText
    private lateinit var cPassET: EditText
    private lateinit var loginB: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fnameET = findViewById(R.id.fNameET)
        lNameET = findViewById(R.id.lNameET)
        emailET = findViewById(R.id.mailInputET)
        passET = findViewById(R.id.passInputET)
        cPassET = findViewById(R.id.cPassInputET)
        loginB = findViewById(R.id.loginBtn)
        loginB.setOnClickListener {
            val fName = fnameET.text.toString()
            val lName = lNameET.text.toString()
            val email = emailET.text.toString()
            val pass = passET.text.toString()
            val cPass = cPassET.text.toString()
            if (email.isEmpty()) {
                emailET.error = "This field must not be empty!"
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailET.error = "Invalid email address!"
                return@setOnClickListener
            }
            if (pass.isEmpty()) {
                passET.error = "This field must not be empty!"
                return@setOnClickListener
            }
            if (cPass.isEmpty()) {
                passET.error = "This field must not be empty!"
                return@setOnClickListener
            }
            if (pass != cPass) {
                cPassET.error = "Passwords must have to be same!"
                return@setOnClickListener
            }

            val intent = Intent(this, HomeActivity::class.java)       //Explicit intent
            intent.putExtra("fName", fName)
            intent.putExtra("lName", lName)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}