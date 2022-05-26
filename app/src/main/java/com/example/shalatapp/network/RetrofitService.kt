package com.example.shalatapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {

    //  Client Bertugas Sebagai Alat Penghubung ke Server
    private val client = OkHttpClient.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://shalat-b013a-default-rtdb.firebaseio.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    // Build Service Digunakan untuk membuat service sesuai interface retrofit
    fun <T>buildService(service : Class<T>) : T {
        return retrofit.create(service)
    }
}