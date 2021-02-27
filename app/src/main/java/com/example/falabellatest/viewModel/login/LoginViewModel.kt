package com.example.falabellatest.viewModel.login

import androidx.lifecycle.ViewModel
import com.example.core.extension.LiveResult
import com.example.falabellatest.domain.entities.LoginMemory
import com.example.falabellatest.domain.useCases.GeneralUseCases

class LoginViewModel(
    private val generalUseCases: GeneralUseCases
): ViewModel() {
    val dataLiveData = LiveResult<LoginMemory?>()

    fun getLogin(username: String, password: String){
        generalUseCases.getLogin(dataLiveData, username, password)
    }
    fun setLogin(){
        generalUseCases.setLogin()
    }
}