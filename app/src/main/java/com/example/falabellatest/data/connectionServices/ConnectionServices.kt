package com.example.falabellatest.data.connectionServices

import com.example.falabellatest.data.entities.HeaderEntry
import retrofit2.Call
import retrofit2.http.GET

interface ConnectionServices {

    @GET("/api")
    fun getEconomicIndicators(): Call<HeaderEntry>
}
