package com.satriopndt.kicawcapstone.data.pref

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.satriopndt.kicawcapstone.data.UserModel
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow

val Context.dataStore by preferencesDataStore("session")

class UserPreferences private constructor(private val dataStore: DataStore<Preferences>) {

    fun getSession(): kotlinx.coroutines.flow.Flow<UserModel> {
        return dataStore.data.map { preference ->
            UserModel(
                preference[USER_ID_KEY] ?: "",
                preference[NAME_KEY] ?: "",
                preference[TOKEN_KEY] ?: "",
                preference[IS_LOGIN] ?: false
            )
        }
    }

    suspend fun saveSession(userModel: UserModel) {
        dataStore.edit { preference ->
            preference[USER_ID_KEY] = userModel.userId
            Log.d("This Email", "LoginScreen: ${userModel.userId}")
            preference[NAME_KEY] = userModel.name
            preference[TOKEN_KEY] = userModel.token
            Log.d("This name", "LoginScreen: ${userModel.name}")
            Log.d("This token", "LoginScreen: ${userModel.token}")
            preference[IS_LOGIN] = true
        }
    }

    suspend fun logout() {
        dataStore.edit { preference ->
            preference.clear()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreferences? = null

        private val USER_ID_KEY = stringPreferencesKey("key_id")
        private val NAME_KEY = stringPreferencesKey("name_key")
        private val TOKEN_KEY = stringPreferencesKey("token_key")
        private val IS_LOGIN = booleanPreferencesKey("isLogin_key")

        fun getInsance(dataStore: DataStore<Preferences>): UserPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreferences(dataStore)
                    INSTANCE = instance
                    instance
            }
        }
    }
}