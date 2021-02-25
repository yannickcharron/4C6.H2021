package ca.qc.cstj.s05localdatasource.helpers

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import ca.qc.cstj.s05localdatasource.MyApplication
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import java.io.IOException

object LocalStorage {

    //val dataStore = MyApplication.appContext.createDataStore(name = "exemple.localstorage")

}