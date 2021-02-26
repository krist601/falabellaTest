package com.example.falabellatest.data.connectionServices

import com.example.falabellatest.data.entities.HeaderEntry
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ConnectionServices {

    @GET("/api")
    fun getEconomicIndicators(@QueryMap filter: Map<String, String>): Call<HeaderEntry>
}
