package com.example.cryptoinfo.network

import com.squareup.moshi.Json

data class CryptoLabel(
    val id: String,
            @Json(name = "crypto_label") val CryptoLabelUrl: String) {
    // JSON аннотация используется, чтобы использовать имена переменных в классе данных, отличные от имен ключей в ответе JSON

}