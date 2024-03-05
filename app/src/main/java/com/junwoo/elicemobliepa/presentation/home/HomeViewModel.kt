package com.junwoo.elicemobliepa.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.google.gson.Gson
import com.junwoo.elicemobliepa.domain.repository.remote.HomeRepository
import com.junwoo.elicemobliepa.domain.usecase.GetSavedMyCourseListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val getSavedMyCourseRawData: GetSavedMyCourseListUseCase
) : ViewModel() {

    fun getCourses(
        filterIsRecommended: Boolean? = null,
        filterIsFree: Boolean? = null,
        filterCondition: Boolean = false
    ) = flow {
        val filterConditions =
            if (filterCondition) getSavedMyCourseRawData.invoke().first() else null
        emitAll(
            homeRepository.fetchCourseItems(filterIsRecommended, filterIsFree, Gson().toJson(mapOf("course_ids" to filterConditions)))
                .cachedIn(viewModelScope)
        )
    }
}