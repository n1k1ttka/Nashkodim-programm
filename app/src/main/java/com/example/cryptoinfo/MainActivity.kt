package com.example.cryptoinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading)
        //setSupportActionBar(findViewById(R.id.toolbar))

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, CryptoActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}