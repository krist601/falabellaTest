package com.example.falabellatest.ui.util

import android.view.View
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    protected fun onLoading(progressBar: View?, noDataLabel: View?, dataView: View?, reloadButton: View?) {
        noDataLabel?.let { it.visibility = View.GONE }
        progressBar?.let { it.visibility = View.VISIBLE }
        dataView?.let { it.visibility = View.GONE }
        reloadButton?.let { it.visibility = View.GONE }
    }

    protected fun onError(progressBar: View?, noDataLabel: View?, dataView: View?, reloadButton: View?) {
        noDataLabel?.let { it.visibility = View.GONE }
        progressBar?.let { it.visibility = View.GONE }
        dataView?.let { it.visibility = View.GONE }
        reloadButton?.let { it.visibility = View.VISIBLE }
    }

    protected fun onNoData(progressBar: View?, noDataLabel: View?, dataView: View?, reloadButton: View?) {
        noDataLabel?.let { it.visibility = View.VISIBLE }
        progressBar?.let { it.visibility = View.GONE }
        dataView?.let { it.visibility = View.GONE }
        reloadButton?.let { it.visibility = View.GONE }
    }

    protected fun onSuccess(progressBar: View?, noDataLabel: View?, dataView: View?, reloadButton: View?) {
        noDataLabel?.let { it.visibility = View.GONE }
        progressBar?.let { it.visibility = View.GONE }
        dataView?.let { it.visibility = View.VISIBLE }
        reloadButton?.let { it.visibility = View.GONE }
    }
}