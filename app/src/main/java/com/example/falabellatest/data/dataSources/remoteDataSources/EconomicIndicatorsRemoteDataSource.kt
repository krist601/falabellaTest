package com.example.falabellatest.data.dataSources.remoteDataSources

import com.example.core.extension.await
import com.example.falabellatest.data.connectionServices.ConnectionServices
import com.example.falabellatest.data.entities.HeaderEntry

class EconomicIndicatorsRemoteDataSource(
    private val connectionServices: ConnectionServices
) {
    suspend fun getEconomicIndicators(): HeaderEntry {
        return  connectionServices.getEconomicIndicators().await()!!
    }
}