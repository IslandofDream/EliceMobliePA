package com.junwoo.elicemobliepa.di

import com.junwoo.elicemobliepa.data.repository.datastore.DataStoreRepositoryImpl
import com.junwoo.elicemobliepa.data.repository.detail.DetailRepositoryImpl
import com.junwoo.elicemobliepa.data.repository.home.HomeRepositoryImpl
import com.junwoo.elicemobliepa.domain.repository.datastore.DataStoreRepository
import com.junwoo.elicemobliepa.domain.repository.detail.DetailRepository
import com.junwoo.elicemobliepa.domain.repository.home.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindToHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    abstract fun bindToDetailRepository(detailRepositoryImpl: DetailRepositoryImpl): DetailRepository

    @Binds
    @Singleton
    abstract fun bindToDataStoreRepository(dataStoreRepositoryImpl: DataStoreRepositoryImpl): DataStoreRepository
}