package com.omdb.app.utils

import android.content.Context
import android.text.Html
import android.text.Spanned
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * @Details :ContextExt
 * @Author Roshan Bhagat
 */

fun Context.dismissKeyboard(view: View?) {
    view?.let {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()

}

fun Context.fromHtmlWithParams(@StringRes stringRes: Int, parameter: String? = null): Spanned {

    val stringText = if (parameter.isNullOrEmpty()) {
        this.getString(stringRes)
    } else {
        this.getString(stringRes, parameter)
    }

    return Html.fromHtml(stringText, Html.FROM_HTML_MODE_LEGACY)

}