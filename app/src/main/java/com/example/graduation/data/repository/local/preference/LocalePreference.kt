package com.example.graduation.data.repository.local.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import com.example.graduation.data.repository.local.preference.PreferencesKeys.isLogin
import com.example.graduation.data.repository.local.preference.PreferencesKeys.latPreferencesKey
import com.example.graduation.data.repository.local.preference.PreferencesKeys.longPreferencesKey
import com.example.graduation.data.repository.local.preference.PreferencesKeys.userId
import javax.inject.Inject


class LocalePreference @Inject constructor(private val dataStore: DataStore<Preferences>) {



    suspend fun setLoginState(isLogin: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.isLogin] = isLogin
        }
    }
    suspend fun getLoginState(): Boolean? = dataStore.data.first()[isLogin]

    suspend fun saveToken(id: String) {
        dataStore.edit { preferences ->
            preferences[userId] = id
        }
    }

    suspend fun getToken(): String? = dataStore.data.first()[userId]


    suspend fun removeToken() {
        dataStore.edit { preferences ->
            preferences[userId] = ""
        }
    }

    suspend fun setLatLang(lat: String,long: String) {
        dataStore.edit { preferences ->
            preferences[latPreferencesKey] = lat
            preferences[longPreferencesKey] = long
        }
    }
    suspend fun getLat(): String? = dataStore.data.first()[latPreferencesKey]
    suspend fun getLong(): String? = dataStore.data.first()[longPreferencesKey]

    suspend fun removeUserData() {
        dataStore.edit { preferences ->
            preferences[userId] = ""
            preferences[latPreferencesKey] = ""
            preferences[longPreferencesKey] = ""
            preferences[isLogin] = false
        }
    }
}