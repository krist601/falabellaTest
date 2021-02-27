package com.example.falabellatest.data.dataSources.localDataSources

import android.content.Context
import android.content.SharedPreferences
import com.example.falabellatest.data.entities.LoginEntry
import com.google.gson.reflect.TypeToken

class GeneralLocalDataSource(
    context: Context
) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("falabella.preferences", Context.MODE_PRIVATE)

    fun getLogin(username: String, password: String): LoginEntry? {
        return sharedPreferences.getString(username, null)?.let {
            LoginEntry.create(it, object : TypeToken<LoginEntry>() {}.type).let {
                    login -> if(login.comparePassword(password))
                        login
            else
                null
            } }
    }
    fun setLogin(username: String, login: LoginEntry){
        sharedPreferences.edit().putString(username,login.serialize()).apply()
    }
}