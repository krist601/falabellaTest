package com.example.falabellatest.data.dataSources.localDataSources

import android.content.Context
import android.content.SharedPreferences

class GeneralLocalDataSource(
    context: Context
) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("falabella.preferences", Context.MODE_PRIVATE)
}