package com.junwoo.elicemobliepa.di

import com.junwoo.elicemobliepa.data.repository.local.DataStoreRepositoryImpl
import com.junwoo.elicemobliepa.data.repository.remote.DetailRepositoryImpl
import com.junwoo.elicemobliepa.data.repository.remote.HomeRepositoryImpl
import com.junwoo.elicemobliepa.domain.repository.local.DataStoreRepository
import com.junwoo.elicemobliepa.domain.repository.remote.DetailRepository
import com.junwoo.elicemobliepa.domain.repository.remote.HomeRepository
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
}