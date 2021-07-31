package com.example.ussd

import android.app.Dialog
import com.example.ussd.Fragment.BoshSahifa

object BaseAnimation {
    fun showLoadingAnimation(context: BoshSahifa): Dialog {

        val loadingDialog = Dialog(context)

        loadingDialog.let {
            it.show()
            it.setContentView(R.layout.loading_animation)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(true)
            return it
        }

    }
}