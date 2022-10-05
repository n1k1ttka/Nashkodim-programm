package com.example.cryptoinfo.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

private const val BASE_URL =
    "https://api.coingecko.com/api/v3/"
private val moshi = Moshi.Builder() // Конструктор Moshi для сборки и создания объекта Moshi
    .add(KotlinJsonAdapterFactory()) // Чтобы аннотации Moshi правильно работали с Kotlin
    .build() // Создали объект Moshi
private val retrofit = Retrofit.Builder() // Конструктор Retrofit для сборки и создания объекта Retrofit
    .addConverterFactory(MoshiConverterFactory.create(moshi)) // Конвертер (в него передаем объект Moshi) сообщает Retrofit, что делать с данными, которые он получает
    .baseUrl(BASE_URL) // Поместили базовый URL/Создали URI
    .build() // Создали объект Retrofit
interface CryptoApiService {

    @GET ("labels") // Когда getLabels() метод вызывается, Retrofit добавляет конечную точку labels к базовому URL-адресу с помощью запроса GET
    suspend fun getLabels(): List<CryptoLabel>
}
object GeckoApi {
    val retrofitService : CryptoApiService by lazy {
        retrofit.create(CryptoApiService::class.java)}
}
