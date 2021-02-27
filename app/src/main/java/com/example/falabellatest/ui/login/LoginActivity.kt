package com.example.falabellatest.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.falabellatest.databinding.ActivityLoginBinding
import com.example.falabellatest.viewModel.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    //******************* VIEW VARIABLES *******************//

    private val viewModel: LoginViewModel by viewModel()
    lateinit var binding: ActivityLoginBinding

    //******************* VIEW LIFECYCLE *******************//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}