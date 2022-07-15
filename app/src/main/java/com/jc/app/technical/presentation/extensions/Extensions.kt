package com.jc.app.technical.presentation.extensions

import android.app.Activity
import android.view.View
import android.widget.Toast
import com.jc.app.technical.presentation.utils.SafeOnClickListener

fun Activity.showToast(message: Any?) {
    val textToShow = when (message) {
        is Int -> getString(message)
        is String -> message
        else -> {
            ""
        }
    }
    Toast.makeText(this, textToShow, Toast.LENGTH_LONG).show()
}

fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeOnClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}
