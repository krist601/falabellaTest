package com.example.falabellatest.ui.login

import android.content.Intent
import android.os.Bundle
import com.example.core.coroutines.Result
import com.example.core.extension.observe
import com.example.falabellatest.R
import com.example.falabellatest.databinding.ActivityLoginBinding
import com.example.falabellatest.domain.entities.EconomicIndicatorMemory
import com.example.falabellatest.domain.entities.HeaderMemory
import com.example.falabellatest.domain.entities.LoginMemory
import com.example.falabellatest.ui.economicIndicators.EconomicIndicatorsActivity
import com.example.falabellatest.ui.economicIndicators.detail.EconomicIndicatorDetailActivity
import com.example.falabellatest.ui.util.BaseActivity
import com.example.falabellatest.ui.util.economicIndicatorMemory
import com.example.falabellatest.ui.util.showAlertView
import com.example.falabellatest.ui.util.userLogged
import com.example.falabellatest.viewModel.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    //******************* VIEW VARIABLES *******************//

    private val viewModel: LoginViewModel by viewModel()
    lateinit var binding: ActivityLoginBinding

    //******************* VIEW LIFECYCLE *******************//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(viewModel) { observe(dataLiveData, ::dataObserver) }

        binding.loginButton.setOnClickListener { viewModel.getLogin(binding.usernameTextView.text.toString(), binding.passwordTextView.text.toString()) }
    }

    private fun dataObserver(result: Result<LoginMemory?>?) {
        when (result) {
            is Result.OnLoading -> onLoading(binding.progressBar, binding.noDataTextView, binding.container, binding.reloadButton)
            is Result.OnSuccess -> {
                userLogged = result.value
                binding.usernameTextView.setText("")
                binding.passwordTextView.setText("")
                startActivity(Intent().setClass(this, EconomicIndicatorsActivity::class.java))
            }
            else -> {
                onError(binding.progressBar, binding.noDataTextView, null, binding.container)
                showAlertView(this, getString(R.string.activity_login_error_title), getString(R.string.activity_login_error_body), "error", getString(R.string.activity_login_error_button)) { _, _ ->  }
            }
        }
    }
    override fun onBackPressed() { /*Empty*/ }
}