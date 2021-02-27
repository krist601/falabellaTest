package com.example.falabellatest.data.util

import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

fun encrypt(strToEncrypt: String?): String {
    return strToEncrypt?.let {
        val plaintext: ByteArray = it.toByteArray()
        val keygen = KeyGenerator.getInstance("AES")
        keygen.init(256)
        val key: SecretKey = keygen.generateKey()
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val ciphertext: ByteArray = cipher.doFinal(plaintext)
        val iv: ByteArray = cipher.iv
        print("iv $iv")
        print("ciphertext $ciphertext")
        ciphertext.toString()
    } ?: ""
}