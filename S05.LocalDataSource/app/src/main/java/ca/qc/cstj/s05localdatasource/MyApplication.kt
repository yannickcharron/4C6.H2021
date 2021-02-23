package ca.qc.cstj.s05localdatasource

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    companion object {
        private lateinit var instance : Application

        val appContext: Context
            get() = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}