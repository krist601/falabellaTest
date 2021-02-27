package com.example.falabellatest.domain.entities

import com.example.falabellatest.data.entities.LoginEntry
import com.example.falabellatest.data.util.encrypt

class LoginMemory (
    var username: String?,
    var password: String?
){
    fun toEntityEntry() = LoginEntry(
        username = username,
        password = password//encrypt(password)
    )
}