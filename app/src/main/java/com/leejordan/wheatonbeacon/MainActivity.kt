package com.leejordan.wheatonbeacon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailfield = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val passwordfield = findViewById<EditText>(R.id.editTextTextPassword)
        val loginButton = findViewById<Button>(R.id.button2)

        loginButton.setOnClickListener {
            if(checkWheaton(emailfield.text.toString(), passwordfield.text.toString())){
                Toast.makeText(this@MainActivity, "Successfully logged in!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /* the following function makes sure the email and password are correct
        and within Wheaton's database */
    fun checkWheaton(e: String, pw: String): Boolean {
        //make sure it's not empty
        if(e.isEmpty() || pw.isEmpty()){
            Toast.makeText(this@MainActivity, "Please enter an email and password.", Toast.LENGTH_SHORT).show()
            return false
        }
        //make sure email is a my.wheaton.edu email
        else if(!e.contains("@my.wheaton.edu")) {
            Toast.makeText(
                this@MainActivity,
                "Your email must be a Wheaton account",
                Toast.LENGTH_SHORT
            ).show()
            return false;
        }
        else{
            return true
        }


    }



}