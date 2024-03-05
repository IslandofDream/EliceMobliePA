package com.junwoo.elicemobliepa.data.repository.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.junwoo.elicemobliepa.data.util.Constant
import com.junwoo.elicemobliepa.domain.repository.local.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepository {

    override suspend fun saveMyCourseList(list: List<Int>) {
        val gson = Gson()
        val json = gson.toJson(list)
        dataStore.edit { preferences ->
            preferences[Constant.DATASTORE_KEY] = json
        }
    }

    override fun getMyCourseList(): Flow<List<Int>> {
        return dataStore.data.catch {
            throw it
        }.map { preferences ->
            val gson = Gson()
            val json = preferences[Constant.DATASTORE_KEY] ?: ""
            if (json.isNotEmpty()) {
                val type = object : TypeToken<List<Int>>() {}.type
                gson.fromJson<List<Int>>(json, type)
            } else {
                emptyList()
            }
        }
    }
}


