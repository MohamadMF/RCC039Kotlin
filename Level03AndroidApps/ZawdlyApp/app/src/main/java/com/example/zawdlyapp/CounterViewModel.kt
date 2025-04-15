package com.example.zawdlyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private  var liveCounter = MutableLiveData(0)

    val newCounter : LiveData<Int> = liveCounter

    fun makeIncrement() {
        liveCounter.value = liveCounter.value?.plus(1)
    }

    fun resetIncrement() {
        liveCounter.value = 0
    }
}