package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val webView : WebView = findViewById<WebView>(R.id.webView);
        webView.settings.javaScriptEnabled = true;
        webView.webViewClient = WebViewClient();
        webView.loadUrl("https://www.google.com/search?q=istf")

        val toIntent : TextView = findViewById<Button>(R.id.toIntent)
        val loginIntent = Intent(this,loginActivity::class.java)


        toIntent.setOnClickListener(View.OnClickListener {
            startActivity(loginIntent)
        })


    }
}