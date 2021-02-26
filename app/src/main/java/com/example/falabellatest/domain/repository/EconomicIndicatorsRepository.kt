package com.example.falabellatest.domain.repository

import com.example.falabellatest.data.dataSources.localDataSources.EconomicIndicatorsLocalDataSource
import com.example.falabellatest.data.dataSources.remoteDataSources.EconomicIndicatorsRemoteDataSource

class EconomicIndicatorsRepository(
    private val economicIndicatorsRemoteDataSource: EconomicIndicatorsRemoteDataSource,
    private val economicIndicatorsDataSource: EconomicIndicatorsLocalDataSource
) {
}