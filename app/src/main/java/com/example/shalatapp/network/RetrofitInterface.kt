package com.example.shalatapp.network

import com.example.shalatapp.model.BatalShalatItem
import com.example.shalatapp.model.DalilShalatItem
import com.example.shalatapp.model.ShalatItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("Data/kategorishalat.json")
    suspend fun getDataShalatWajib() : Response<List<ShalatItem>>

    @GET("Data/dalilshalat.json")
    suspend fun getDalil() : Response<List<DalilShalatItem>>

    @GET("Data/batalshalat.json")
    suspend fun getDataBatalShalat() : Response<List<BatalShalatItem>>

}