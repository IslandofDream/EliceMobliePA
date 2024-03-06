package com.junwoo.elicemobliepa.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import com.junwoo.elicemobliepa.domain.repository.home.HomeRepository
import com.junwoo.elicemobliepa.domain.usecase.GetSavedMyCourseListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val getSavedMyCourseListUseCase: GetSavedMyCourseListUseCase
) : ViewModel() {

    private val _freeCourses = MutableStateFlow<PagingData<CourseItemEntity>>(PagingData.empty())
    val freeCourses = _freeCourses.asStateFlow()

    private val _recommendCourses =
        MutableStateFlow<PagingData<CourseItemEntity>>(PagingData.empty())
    val recommendCourses = _recommendCourses.asStateFlow()

    private val _myCourses = MutableStateFlow<PagingData<CourseItemEntity>>(PagingData.empty())
    val myCourses = _myCourses.asStateFlow()

    init {
        fetchCourses()
    }

    private fun fetchCourses() {
        fetchFreeCourses()
        fetchRecommendedCourses()
        fetchMyCourses()
    }

    private fun fetchFreeCourses() = viewModelScope.launch {
        fetchAndSetCourseItems(_freeCourses, filterIsFree = true)
    }

    private fun fetchRecommendedCourses() = viewModelScope.launch {
        fetchAndSetCourseItems(_recommendCourses, filterIsRecommended = true)
    }

    fun fetchMyCourses() = viewModelScope.launch {
        fetchAndSetCourseItems(
            _myCourses,
            filterConditions = getSavedMyCourseListUseCase.invoke().first()
        )
    }

    private fun fetchAndSetCourseItems(
        stateFlow: MutableStateFlow<PagingData<CourseItemEntity>>,
        filterIsRecommended: Boolean? = null,
        filterIsFree: Boolean? = null,
        filterConditions: List<Int>? = null
    ) = viewModelScope.launch {
        runCatching {
            homeRepository.fetchCourseItems(
                filterIsRecommended = filterIsRecommended,
                filterIsFree = filterIsFree,
                filterConditions = filterConditions
            )
        }.onSuccess {
            it.collect { pagingData ->
                stateFlow.value = pagingData
            }
        }.onFailure {
            throw it
        }
    }
}