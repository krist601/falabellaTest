package com.example.falabellatest.domain.useCases

import com.example.core.extension.LiveResult
import com.example.core.extension.postError
import com.example.core.extension.postSuccess
import com.example.falabellatest.domain.entities.LoginMemory
import com.example.falabellatest.domain.repository.GeneralRepository
import com.example.falabellatest.domain.util.RESPONSE_ERROR_CODE
import com.example.falabellatest.domain.util.RESPONSE_SUCCESS_CODE

class GeneralUseCases(
    val repository: GeneralRepository
) {
    fun getLogin(liveData: LiveResult<LoginMemory?>, username: String, password: String){
        repository.getLogin(username, password).let { response ->
            when (response.first) {
                RESPONSE_SUCCESS_CODE -> liveData.postSuccess(response.second)
                RESPONSE_ERROR_CODE -> liveData.postError()
            }
        }
    }
    fun setLogin(username: String, password: String){
        repository.setLogin(username, password)
    }
}