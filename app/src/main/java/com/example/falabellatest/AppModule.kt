package com.example.falabellatest

import android.content.Context
import android.net.ConnectivityManager
import com.example.falabellatest.data.connectionServices.ConnectionServices
import com.example.falabellatest.data.dataSources.localDataSources.EconomicIndicatorsLocalDataSource
import com.example.falabellatest.data.dataSources.localDataSources.GeneralLocalDataSource
import com.example.falabellatest.data.dataSources.remoteDataSources.EconomicIndicatorsRemoteDataSource
import com.example.falabellatest.domain.repository.EconomicIndicatorsRepository
import com.example.falabellatest.domain.repository.GeneralRepository
import com.example.falabellatest.domain.useCases.EconomicIndicatorsUseCases
import com.example.falabellatest.domain.useCases.GeneralUseCases
import com.example.falabellatest.viewModel.economicIndicators.EconomicIndicatorsViewModel
import com.example.falabellatest.viewModel.login.LoginViewModel
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { get<Retrofit>().create(ConnectionServices::class.java) as ConnectionServices }
}

val remoteDataSourceModule = module {
    factory { EconomicIndicatorsRemoteDataSource(get()) }
}

val localDataSourceModule = module {
    factory { EconomicIndicatorsLocalDataSource(get()) }
    factory { GeneralLocalDataSource(get()) }
}

val repositoryModule = module {
    factory { EconomicIndicatorsRepository(get(), get()) }
    factory { GeneralRepository(get()) }
}

val useCaseModule = module {
    factory { EconomicIndicatorsUseCases(get()) }
    factory { GeneralUseCases(get()) }
}

val viewModelModule = module {
    viewModel { EconomicIndicatorsViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}

val appModule = module(override = true) {
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(url)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        Picasso.get()
    }
}
