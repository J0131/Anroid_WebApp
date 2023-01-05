package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val cancelButton : Button = findViewById<Button>(R.id.cancel)

        val intentWeb : Intent = Intent(this, MainActivity::class.java)
        cancelButton.setOnClickListener(
            View.OnClickListener {
                startActivity(intentWeb)
            }
        )

        val registerButton : Button = findViewById<Button>(R.id.Register)

        val intentRegister : Intent = Intent(this, RegisterActivity::class.java)
        registerButton.setOnClickListener(View.OnClickListener {
            startActivity(intentRegister)
        })


    }
}