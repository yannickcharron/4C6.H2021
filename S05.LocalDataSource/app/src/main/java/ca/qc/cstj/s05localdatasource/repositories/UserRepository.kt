package ca.qc.cstj.s05localdatasource.repositories

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import ca.qc.cstj.s05localdatasource.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Propriété d'extension sur la class Context
val Context.dataStore by preferencesDataStore("s05.user")

class UserRepository(private val context:Context) {

    object PreferencesKeys {
        val FIRST_NAME = stringPreferencesKey("first_name")
        val LAST_NAME = stringPreferencesKey("last_name")
        val IS_ONLINE = booleanPreferencesKey("is_online")
    }

    val user: Flow<User> = context.dataStore.data.map {
        val firstName = it[PreferencesKeys.FIRST_NAME] ?: ""
        val lastName = it[PreferencesKeys.LAST_NAME] ?: ""
        val isOnline = it[PreferencesKeys.IS_ONLINE] ?: true
        User(firstName, lastName, isOnline)
    }

    suspend fun update(firstName: String, lastName:String, isOnline:Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.FIRST_NAME] = firstName
            preferences[PreferencesKeys.LAST_NAME] = lastName
            preferences[PreferencesKeys.IS_ONLINE] = isOnline
        }
    }
}