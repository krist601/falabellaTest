package com.example.falabellatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.falabellatest.ui.economicIndicators.EconomicIndicatorsActivity
import com.example.falabellatest.ui.login.LoginActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initKoin()
        startApp()
    }
    private fun startApp() {
        startActivity(Intent().setClass(this, EconomicIndicatorsActivity::class.java))
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