package com.junwoo.elicemobliepa.di

import com.junwoo.elicemobliepa.data.remote.DetailCourseDataSource
import com.junwoo.elicemobliepa.data.remote.DetailCourseDataSourceImpl
import com.junwoo.elicemobliepa.data.remote.EliceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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

}