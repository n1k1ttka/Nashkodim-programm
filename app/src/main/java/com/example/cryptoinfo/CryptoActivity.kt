package com.example.cryptoinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.cryptoinfo.network.CryptoLabel
import com.example.cryptoinfo.overview.OverviewViewModel

class CryptoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto)

        val model: OverviewViewModel by viewModels()
        model.getCryptoLabels().observe(this, Observer<List<CryptoLabel>>{labels ->
        // Update UI
        })

        //setSupportActionBar(findViewById(R.id.toolbar))
    }
}