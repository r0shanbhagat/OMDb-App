package com.truecaller.truecallerblog.ui.view.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.truecaller.truecallerblog.R
import com.truecaller.truecallerblog.databinding.ProgressDialogBinding


/**
 * @Details ProgressDialog:
 * @Author Roshan Bhagat
 * @constructor Create [ProgressDialog]
 *
 * @param context
 */
class ProgressDialog(context: Context) : Dialog(context) {

    init {
        window?.setLayout(
            android.view.ViewGroup.LayoutParams.MATCH_PARENT,
            android.view.ViewGroup.LayoutParams.MATCH_PARENT
        )

        val mBinding = DataBindingUtil.inflate<ProgressDialogBinding>(
            LayoutInflater.from(context),
            R.layout.progress_dialog,
            null,
            false
        )
        setContentView(mBinding.root)

        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val animation = mBinding.ivProgress.background as AnimationDrawable
        animation.start()
    }
}