package com.example.falabellatest.viewModel.economicIndicators

import androidx.lifecycle.ViewModel
import com.example.core.extension.LiveResult
import com.example.falabellatest.domain.entities.EconomicIndicatorMemory
import com.example.falabellatest.domain.entities.HeaderMemory
import com.example.falabellatest.domain.useCases.EconomicIndicatorsUseCases
import com.example.falabellatest.ui.economicIndicators.EconomicIndicatorsAdapter

class EconomicIndicatorsViewModel(
    private val economicIndicatorsUseCases: EconomicIndicatorsUseCases
): ViewModel() {
    lateinit var adapter: EconomicIndicatorsAdapter
    val dataLiveData = LiveResult<HeaderMemory?>()
    var totalData: List<EconomicIndicatorMemory?>? = null

    fun getData() {
        economicIndicatorsUseCases.getEconomicIndicators(dataLiveData)
    }

    fun initAdapter(activity: EconomicIndicatorsAdapter.OnClickItemListener){
        adapter = EconomicIndicatorsAdapter(mutableListOf(), activity)
    }

    fun updateData(result: HeaderMemory) {
        totalData = result.economicIndicators
        result.economicIndicators?.let { adapter.setData(it) }
    }

    @ExperimentalStdlibApi
    fun filterData(filter: String){
        if (filter.isNotBlank()) totalData?.filter { it?.nombre?.lowercase()?.contains(filter.lowercase()) ?: false }?.let { adapter.setData(it) } else totalData?.let { adapter.setData(it) }
    }
}