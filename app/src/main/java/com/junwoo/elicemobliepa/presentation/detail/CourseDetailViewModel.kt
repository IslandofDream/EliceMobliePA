package com.junwoo.elicemobliepa.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junwoo.elicemobliepa.core.ApiResult
import com.junwoo.elicemobliepa.domain.entity.CourseDetailEntity
import com.junwoo.elicemobliepa.domain.entity.LectureEntity
import com.junwoo.elicemobliepa.domain.repository.remote.DetailRepository
import com.junwoo.elicemobliepa.presentation.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseDetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {

    private val _detailCourseStateFlow = MutableStateFlow<UiState<CourseDetailEntity>>(UiState.Init)
    val detailCourseStateFlow = _detailCourseStateFlow.asStateFlow()

    private val _lectureListStateFlow = MutableStateFlow<UiState<List<LectureEntity>>>(UiState.Init)
    val lectureListStateFlow = _lectureListStateFlow.asStateFlow()

    fun getCourseDetail(courseId: Int) {
        viewModelScope.launch {
            _detailCourseStateFlow.value = UiState.Loading
            kotlin.runCatching {
                detailRepository.getCourseDetail(courseId = courseId)
            }.onSuccess {
                it.collect { collect ->
                    when (collect) {
                        is ApiResult.Success -> {
                            _detailCourseStateFlow.value = UiState.Success(collect.data)
                        }

                        is ApiResult.Error -> {
                            _detailCourseStateFlow.value = UiState.Error(collect.message)
                        }
                    }
                }
            }.onFailure {
                throw it
            }
        }
    }

    fun getLectureList(courseId: Int, offset: Int, count: Int) {
        viewModelScope.launch {
            _lectureListStateFlow.value = UiState.Loading
            kotlin.runCatching {
                detailRepository.getLectures(courseId = courseId, offset = offset, count = count)
            }.onSuccess {
                it.collect { collect ->
                    when (collect) {
                        is ApiResult.Success -> {
                            _lectureListStateFlow.value = UiState.Success(collect.data)
                        }

                        is ApiResult.Error -> {
                            _lectureListStateFlow.value = UiState.Error(collect.message)
                        }
                    }
                }
            }.onFailure {
                throw it
            }
        }
    }


}