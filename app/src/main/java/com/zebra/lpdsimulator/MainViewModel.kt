package com.zebra.lpdsimulator

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val message: MutableState<String> = mutableStateOf("")

    fun triggerLPDAlert(context: Context) {
        context.startActivity(Intent(context, FullscreenActivity::class.java))
    }

    fun displayMessage(message: String) {
        this.message.value = message
    }
}