package com.example.fragments.utils

import android.os.Bundle
import androidx.core.os.bundleOf

class ArgumentManager {
    private val KEY_COUNTER_ARG = "KEY_COUNTER_ARG"

    fun getCounter(args: Bundle?): Int = args?.getInt(KEY_COUNTER_ARG) ?: 0
    fun createArgs(counter: Int) = bundleOf(KEY_COUNTER_ARG to counter)
}