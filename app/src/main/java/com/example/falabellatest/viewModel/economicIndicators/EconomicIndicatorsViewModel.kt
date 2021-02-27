package com.example.falabellatest.viewModel.economicIndicators

import androidx.lifecycle.ViewModel
import com.example.core.extension.LiveResult
import com.example.falabellatest.domain.entities.HeaderMemory
import com.example.falabellatest.domain.useCases.EconomicIndicatorsUseCases
import com.example.falabellatest.ui.economicIndicators.EconomicIndicatorsAdapter

class EconomicIndicatorsViewModel(
    private val economicIndicatorsUseCases: EconomicIndicatorsUseCases
): ViewModel() {
    lateinit var adapter: EconomicIndicatorsAdapter
    val dataLiveData = LiveResult<HeaderMemory?>()

    fun getData() {
        economicIndicatorsUseCases.getEconomicIndicators(dataLiveData)
    }

    fun initAdapter(activity: EconomicIndicatorsAdapter.OnClickItemListener){
        adapter = EconomicIndicatorsAdapter(mutableListOf(), activity)
    }

    fun updateData(result: HeaderMemory) {
        result.economicIndicators?.let { adapter.setData(it) }
    }
}