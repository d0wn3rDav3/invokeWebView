package com.example.invokewebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var urlEditText: EditText
    private lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        urlEditText = findViewById(R.id.urlEditText)

        // Enable Javascript in the browser
        webView.settings.javaScriptEnabled = true

        // Create a WebViewClient to handle navigation
        webView.webViewClient = WebViewClient()

        // Load the Default URL or handle URL support from the user
        val defaultUrl = "https://icanhazip.com"
        loadUrl(defaultUrl)

        // Set up a listener for URL Input
        urlEditText.setOnEditorActionListener{_, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_DONE ||
            event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN
        )
        {
            val enteredUrl = urlEditText.text.toString()
            loadUrl(enteredUrl)
            return@setOnEditorActionListener true
        }
        false
    }

    }

    private fun loadUrl(url: String) {
        webView.loadUrl(url)
    }
}