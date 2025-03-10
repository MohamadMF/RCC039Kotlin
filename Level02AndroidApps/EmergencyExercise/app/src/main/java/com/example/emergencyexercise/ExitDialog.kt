package com.example.emergencyexercise

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ExitDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder
            .setTitle(getString(R.string.dialog_title))
            .setMessage(getString(R.string.dialog_message))
            .setIcon(android.R.drawable.ic_menu_close_clear_cancel)
            .setPositiveButton(getString(R.string.positive_dialog_btn)) { _, _ -> activity?.finish() }
            .setNegativeButton(getString(R.string.negative_dialog_btn)) { dialog, _ -> dialog.dismiss() }
        return builder.create()
    }
}