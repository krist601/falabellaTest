package com.example.falabellatest.data.dataSources.localDataSources

import android.content.Context
import android.content.SharedPreferences
import com.example.falabellatest.data.entities.HeaderEntry
import com.google.gson.reflect.TypeToken

class EconomicIndicatorsLocalDataSource(
    context: Context
) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("falabella.preferences", Context.MODE_PRIVATE)

    fun getEconomicIndicators(sharedPreferenceName: String): HeaderEntry? {
        return sharedPreferences.getString(sharedPreferenceName, null)?.let { HeaderEntry.create(it, object : TypeToken<HeaderEntry>() {}.type) }
    }
    fun setEconomicIndicators(sharedPreferenceName: String, header: HeaderEntry){
        sharedPreferences.edit().putString(sharedPreferenceName,header.serialize()).apply()
    }
}