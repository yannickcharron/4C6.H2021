package ca.qc.cstj.s07bottomnavigation.ui.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    private var _count = MutableLiveData(0)

    val count get() = _count

    fun add() {
        _count.value = _count.value?.plus(1)
    }

}