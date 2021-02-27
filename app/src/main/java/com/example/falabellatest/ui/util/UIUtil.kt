package com.example.falabellatest.ui.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

fun showAlertView(context: Context, title: String, body: String, icon: String, positiveButton: String, positiveButtonAction: (DialogInterface, Int) -> Unit){
    AlertDialog.Builder(context).setTitle(title)
        .setMessage(body)
        .setIcon(if (icon == "error") android.R.drawable.ic_dialog_alert else android.R.drawable.ic_dialog_info)
        .setPositiveButton(positiveButton, DialogInterface.OnClickListener(positiveButtonAction))
        .show()
}