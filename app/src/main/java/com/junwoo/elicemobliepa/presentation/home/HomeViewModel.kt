package com.junwoo.elicemobliepa.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import com.junwoo.elicemobliepa.domain.repository.remote.HomeRepository
import com.junwoo.elicemobliepa.domain.usecase.GetSavedMyCourseListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val getSavedMyCourseList: GetSavedMyCourseListUseCase
) : ViewModel() {

    fun getCourses(
        filterIsRecommended: Boolean? = null,
        filterIsFree: Boolean? = null,
        filterConditions: String? = null
    ): Flow<PagingData<CourseItemEntity>> {
        return homeRepository.fetchCourseItems(filterIsRecommended, filterIsFree, filterConditions)
            .cachedIn(viewModelScope)
    }
}