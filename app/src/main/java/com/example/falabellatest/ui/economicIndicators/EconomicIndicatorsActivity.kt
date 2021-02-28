package com.example.falabellatest.ui.economicIndicators

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.coroutines.Result
import com.example.core.extension.observe
import com.example.falabellatest.R
import com.example.falabellatest.databinding.ActivityEconomicIndicatorsBinding
import com.example.falabellatest.domain.entities.EconomicIndicatorMemory
import com.example.falabellatest.domain.entities.HeaderMemory
import com.example.falabellatest.ui.economicIndicators.detail.EconomicIndicatorDetailActivity
import com.example.falabellatest.ui.util.BaseActivity
import com.example.falabellatest.ui.util.economicIndicatorMemory
import com.example.falabellatest.ui.util.userLogged
import com.example.falabellatest.viewModel.economicIndicators.EconomicIndicatorsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EconomicIndicatorsActivity : BaseActivity(), EconomicIndicatorsAdapter.OnClickItemListener {

    //******************* VIEW VARIABLES *******************//

    private val viewModel: EconomicIndicatorsViewModel by viewModel()
    lateinit var binding: ActivityEconomicIndicatorsBinding

    //******************* VIEW LIFECYCLE *******************//

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEconomicIndicatorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.initAdapter(this)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.listView.layoutManager = (LinearLayoutManager(this, RecyclerView.VERTICAL, false))
        with(viewModel) { observe(dataLiveData, ::dataObserver) }
        viewModel.getData()

        binding.titleTextView.text = getString(R.string.activity_economic_indicators_title, userLogged?.username)
        binding.logoutButton.setOnClickListener { userLogged = null; finish() }

        binding.searchTextView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.filterData(binding.searchTextView.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {/*empty*/}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {/*empty*/}
        })
    }

    override fun click(item: EconomicIndicatorMemory) {
        economicIndicatorMemory = item
        startActivity(Intent().setClass(this, EconomicIndicatorDetailActivity::class.java))
    }

    private fun dataObserver(result: Result<HeaderMemory?>?) {
        when (result) {
            is Result.OnLoading -> onLoading(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
            is Result.OnSuccess -> {
                if (result.value != null && !result.value?.economicIndicators.isNullOrEmpty()) {
                    viewModel.updateData(result.value!!)
                    onSuccess(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
                } else onNoData(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
            }
            is Result.OnError -> onError(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
            else -> onError(binding.progressBar, binding.noDataTextView, binding.listView, binding.reloadButton)
        }
    }
}