package com.example.falabellatest.data.util

import android.util.Base64
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun encrypt(data: String): String? {
    return try {
        val key = generateKey("falabellafalabellafalabella12345")
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val bytesArray = cipher.doFinal(data.toByteArray())
        Base64.encodeToString(bytesArray, Base64.DEFAULT)
    }catch (e: java.lang.Exception){
        ""
    }

}

@Throws(Exception::class)
private fun generateKey(password: String): SecretKeySpec {
    val digest = MessageDigest.getInstance("SHA-256")
    val bytes = password.toByteArray(charset("UTF-8"))
    digest.update(bytes, 0, bytes.size)
    val key = digest.digest()
    return SecretKeySpec(key, "AES")
}