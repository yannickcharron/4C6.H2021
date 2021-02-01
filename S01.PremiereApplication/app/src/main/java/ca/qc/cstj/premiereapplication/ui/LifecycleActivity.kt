package ca.qc.cstj.premiereapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ca.qc.cstj.premiereapplication.R

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.i("LifeCycle", "1 - onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycle", "2 - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCycle", "2a - onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCycle", "3 - onResume")
    }


    override fun onPause() {
        super.onPause()
        Log.i("LifeCycle", "4 - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycle", "5 - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle", "6 - onDestroy")
    }
}