package com.junwoo.elicemobliepa.di

import com.junwoo.elicemobliepa.domain.usecase.GetSavedMyCourseListUseCase
import com.junwoo.elicemobliepa.domain.usecase.GetSavedMyCourseListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindToGetSavedCourseList(getSavedCourseListUseCase: GetSavedMyCourseListUseCaseImpl): GetSavedMyCourseListUseCase

}