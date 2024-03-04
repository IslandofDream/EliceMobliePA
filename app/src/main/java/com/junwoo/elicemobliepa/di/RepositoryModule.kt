package com.junwoo.elicemobliepa.di

import com.junwoo.elicemobliepa.data.repository.HomeRepositoryImpl
import com.junwoo.elicemobliepa.domain.repository.HomeRepository
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
}