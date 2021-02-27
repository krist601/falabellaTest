package com.example.falabellatest.domain.repository

import com.example.falabellatest.data.dataSources.localDataSources.EconomicIndicatorsLocalDataSource
import com.example.falabellatest.data.dataSources.remoteDataSources.EconomicIndicatorsRemoteDataSource
import com.example.falabellatest.domain.entities.HeaderMemory
import com.example.falabellatest.domain.util.RESPONSE_ERROR_CODE
import com.example.falabellatest.domain.util.RESPONSE_SUCCESS_CODE

class EconomicIndicatorsRepository(
    private val economicIndicatorsRemoteDataSource: EconomicIndicatorsRemoteDataSource,
    private val economicIndicatorsDataSource: EconomicIndicatorsLocalDataSource
) {
    suspend fun getEconomicIndicators(): Pair<Int, HeaderMemory?> {
        val filterString = "economicIndicators"
        runCatching {
            economicIndicatorsRemoteDataSource.getEconomicIndicators()
        }.onSuccess { response ->
            economicIndicatorsDataSource.setEconomicIndicators(filterString, response)
            return Pair(RESPONSE_SUCCESS_CODE, response.toEntityMemory())
        }.onFailure {
            return Pair(RESPONSE_SUCCESS_CODE, economicIndicatorsDataSource.getEconomicIndicators(filterString)?.toEntityMemory())
        }
        return Pair(RESPONSE_ERROR_CODE, null)
    }
}