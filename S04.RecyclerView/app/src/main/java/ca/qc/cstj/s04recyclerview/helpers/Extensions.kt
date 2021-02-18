package ca.qc.cstj.s04recyclerview.helpers

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}

fun ImageView.loadFromResource(context: Context, imageName:String) {
    val imageId = resources.getIdentifier(imageName, "drawable", context.packageName)
    this.setImageResource(imageId)
}