package ca.qc.cstj.s02constraintlayout.helpers

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}