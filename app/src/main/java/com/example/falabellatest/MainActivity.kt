package com.example.falabellatest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.falabellatest.databinding.ActivityMainBinding
import com.example.falabellatest.ui.economicIndicators.EconomicIndicatorsActivity
import com.example.falabellatest.ui.login.LoginActivity
import com.example.falabellatest.viewModel.login.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level

class MainActivity : AppCompatActivity() {

    //******************* VIEW VARIABLES *******************//

    private val viewModel: LoginViewModel by viewModel()
    lateinit var binding: ActivityMainBinding

    //******************* VIEW LIFECYCLE *******************//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initKoin()
        startApp()
        viewModel.setLogin()
    }
    private fun startApp() {
        startActivity(Intent().setClass(this, LoginActivity::class.java))
    }

    //******************* DI *******************//

    private fun initKoin() {
        stopKoin()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainActivity)
            modules(listOf(appModule, viewModelModule, networkModule, repositoryModule, useCaseModule, remoteDataSourceModule, localDataSourceModule))
        }
    }
}