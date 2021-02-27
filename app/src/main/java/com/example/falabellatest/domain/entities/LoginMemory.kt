package com.example.falabellatest.domain.entities

import com.example.falabellatest.data.entities.LoginEntry

class LoginMemory (
    var username: String?,
    var password: String?
){
    fun toEntityEntry() = LoginEntry(
        username = username,
        password = password
    )
}