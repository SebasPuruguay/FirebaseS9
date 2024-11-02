package com.example.firebases9.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val TOKEN =  ""
    private val BASE_URL = "https://fakestoreapi.com/";
    private val cliente = OkHttpClient
        .Builder()
        .addInterceptor(AuthInterceptor(TOKEN))
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(cliente)
            .build()
    }
    val api: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }

}