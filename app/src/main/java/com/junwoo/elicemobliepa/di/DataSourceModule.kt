package com.junwoo.elicemobliepa.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.junwoo.elicemobliepa.data.remote.DetailCourseDataSource
import com.junwoo.elicemobliepa.data.remote.DetailCourseDataSourceImpl
import com.junwoo.elicemobliepa.data.remote.EliceApi
import com.junwoo.elicemobliepa.data.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


val Context.myCourseDataStore: DataStore<Preferences> by preferencesDataStore(
    name = Constant.DATASTORE_NAME
)

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideDetailDataSource(
        eliceApi: EliceApi
    ): DetailCourseDataSource {
        return DetailCourseDataSourceImpl(eliceApi)
    }

    @Provides
    @Singleton
    fun provideMyCourseDataStore(
        @ApplicationContext applicationContext: Context,
    ): DataStore<Preferences> {
        return applicationContext.myCourseDataStore
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

}