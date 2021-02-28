package com.example.falabellatest.domain.repository

import com.example.falabellatest.data.dataSources.localDataSources.GeneralLocalDataSource
import com.example.falabellatest.domain.entities.LoginMemory
import com.example.falabellatest.domain.util.RESPONSE_SUCCESS_CODE
import com.example.falabellatest.domain.util.RESPONSE_UNAUTHORIZED_CODE

class GeneralRepository(
    private val generalDataSource: GeneralLocalDataSource
) {
    fun getLogin(username: String, password: String): Pair<Int, LoginMemory?> {
        return generalDataSource.getLogin(username, password)?.let { Pair(RESPONSE_SUCCESS_CODE, it.toEntityMemory()) } ?: Pair(RESPONSE_UNAUTHORIZED_CODE, null)
    }
    fun setLogin(username: String, password: String) {
        generalDataSource.setLogin(username, LoginMemory(username = username, password = password).toEntityEntry())
    }
}