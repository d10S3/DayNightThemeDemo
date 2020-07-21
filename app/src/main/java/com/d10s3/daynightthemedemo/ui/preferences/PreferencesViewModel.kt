package com.d10s3.daynightthemedemo.ui.preferences

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PreferencesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is preferences Fragment"
    }
    val text: LiveData<String> = _text
}