package com.example.falabellatest.domain.useCases

import com.example.core.extension.LiveResult
import com.example.core.extension.postError
import com.example.core.extension.postSuccess
import com.example.falabellatest.domain.entities.LoginMemory
import com.example.falabellatest.domain.repository.GeneralRepository
import com.example.falabellatest.domain.util.RESPONSE_SUCCESS_CODE
import com.example.falabellatest.domain.util.RESPONSE_UNAUTHORIZED_CODE

class GeneralUseCases(
    val repository: GeneralRepository
) {
    fun getLogin(liveData: LiveResult<LoginMemory?>, username: String, password: String){
        repository.getLogin(username, password).let { response ->
            when (response.first) {
                RESPONSE_SUCCESS_CODE -> liveData.postSuccess(response.second)
                RESPONSE_UNAUTHORIZED_CODE -> liveData.postError()
            }
        }
    }
    fun setLogin(){
        repository.setLogin("admin", "admin")
    }
}