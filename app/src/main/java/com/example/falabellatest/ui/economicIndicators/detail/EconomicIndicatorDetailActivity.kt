package com.example.falabellatest.ui.economicIndicators.detail

import android.os.Bundle
import com.example.falabellatest.R
import com.example.falabellatest.databinding.ActivityEconomicIndicatorDetailBinding
import com.example.falabellatest.domain.entities.EconomicIndicatorMemory
import com.example.falabellatest.ui.util.BaseActivity
import com.example.falabellatest.ui.util.economicIndicatorMemory

class EconomicIndicatorDetailActivity : BaseActivity() {

    //******************* VIEW VARIABLES *******************//

    lateinit var binding: ActivityEconomicIndicatorDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEconomicIndicatorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        economicIndicatorMemory?.let { loadViews(it) }
        binding.backButton.setOnClickListener { finish() }
    }

    private fun loadViews(item: EconomicIndicatorMemory){
        binding.codeTextView.text = getString(
            R.string.activity_economic_indicator_detail_code,
            item.codigo
        )
        binding.nameTextView.text = getString(
            R.string.activity_economic_indicator_detail_name,
            item.nombre
        )
        binding.unitTextView.text = getString(
            R.string.activity_economic_indicator_detail_unit,
            item.unidad_medida
        )
        binding.dateTextView.text = getString(
            R.string.activity_economic_indicator_detail_date,
            item.fecha
        )
        binding.valueTextView.text = getString(
            R.string.activity_economic_indicator_detail_value,
            item.valor.toString()
        )
    }
}