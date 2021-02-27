package com.example.falabellatest.data.entities

import com.example.falabellatest.domain.entities.LoginMemory
import com.google.gson.Gson
import java.lang.reflect.Type

class LoginEntry(
      var username: String?,
      var password: String?
 ) {
    fun toEntityMemory() = LoginMemory(
        username = username,
        password = password
    )
    fun serialize(): String? {
        val data = Gson()
        return data.toJson(this)
    }
    companion object {
        fun create(serializedData: String?, dataClass: Type): LoginEntry {
            return Gson().fromJson(serializedData, dataClass)
        }
    }
    fun comparePassword(passwordToCompare: String?): Boolean {
        return passwordToCompare.equals(password)
    }
}