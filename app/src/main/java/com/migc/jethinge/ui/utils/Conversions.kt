package com.migc.jethinge.ui.utils

import android.content.Context

object Conversions {

    fun Int.toDp(context: Context): Int = (this / context.resources.displayMetrics.density).toInt()

}