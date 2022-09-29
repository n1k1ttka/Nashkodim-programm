package com.example.cryptoinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CryptoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto)
        supportActionBar?.hide()
    }
}