package com.junwoo.elicemobliepa.di

import com.junwoo.elicemobliepa.domain.usecase.FetchCourseItemsUseCase
import com.junwoo.elicemobliepa.domain.usecase.FetchCourseItemsUseCaseImpl
import com.junwoo.elicemobliepa.domain.usecase.GetCourseDetailUseCase
import com.junwoo.elicemobliepa.domain.usecase.GetCourseDetailUseCaseImpl
import com.junwoo.elicemobliepa.domain.usecase.GetCurriculumLectureListUseCase
import com.junwoo.elicemobliepa.domain.usecase.GetCurriculumLectureListUseCaseImpl
import com.junwoo.elicemobliepa.domain.usecase.GetSavedMyCourseListUseCase
import com.junwoo.elicemobliepa.domain.usecase.GetSavedMyCourseListUseCaseImpl
import com.junwoo.elicemobliepa.domain.usecase.SaveMyCourseListUseCase
import com.junwoo.elicemobliepa.domain.usecase.SaveMyCourseListUseCaseImpl
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
    abstract fun bindToFetchCourseItems(fetchCourseItemsUseCaseImpl: FetchCourseItemsUseCaseImpl): FetchCourseItemsUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindToGetCourseDetail(getCourseDetailUseCaseImpl: GetCourseDetailUseCaseImpl): GetCourseDetailUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindToGetCurriculumLectureList(getCurriculumLectureListUseCaseImpl: GetCurriculumLectureListUseCaseImpl): GetCurriculumLectureListUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindToGetSavedCourseList(getSavedCourseListUseCase: GetSavedMyCourseListUseCaseImpl): GetSavedMyCourseListUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindToSaveMyCourseList(savedMyCourseListUseCaseImpl: SaveMyCourseListUseCaseImpl): SaveMyCourseListUseCase

}