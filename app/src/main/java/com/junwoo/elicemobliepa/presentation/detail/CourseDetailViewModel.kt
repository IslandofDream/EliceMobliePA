package com.junwoo.elicemobliepa.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junwoo.elicemobliepa.core.ApiResult
import com.junwoo.elicemobliepa.domain.entity.CourseDetailEntity
import com.junwoo.elicemobliepa.domain.entity.LectureEntity
import com.junwoo.elicemobliepa.domain.repository.datastore.DataStoreRepository
import com.junwoo.elicemobliepa.domain.repository.detail.DetailRepository
import com.junwoo.elicemobliepa.domain.usecase.GetCourseDetailUseCase
import com.junwoo.elicemobliepa.domain.usecase.GetCurriculumLectureListUseCase
import com.junwoo.elicemobliepa.domain.usecase.GetSavedMyCourseListUseCase
import com.junwoo.elicemobliepa.domain.usecase.SaveMyCourseListUseCase
import com.junwoo.elicemobliepa.presentation.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseDetailViewModel @Inject constructor(
    private val getCourseDetailUseCase: GetCourseDetailUseCase,
    private val getCurriculumLectureListUseCase: GetCurriculumLectureListUseCase,
    private val getSavedMyCourseListUseCase: GetSavedMyCourseListUseCase,
    private val savedMyCourseListUseCase: SaveMyCourseListUseCase,
) : ViewModel() {

    private val _detailCourseStateFlow = MutableStateFlow<UiState<CourseDetailEntity>>(UiState.Init)
    val detailCourseStateFlow = _detailCourseStateFlow.asStateFlow()

    private val _lectureListStateFlow = MutableStateFlow<UiState<List<LectureEntity>>>(UiState.Init)
    val lectureListStateFlow = _lectureListStateFlow.asStateFlow()

    private val _appliedStateFlow = MutableStateFlow(false)
    val appliedStateFlow = _appliedStateFlow.asStateFlow()

    // DataStore에서 해당 id가 리스트에 있는지 없는지 작업중에는 수강 버튼의 활성화를 막아두기 위한 Flow입니다.
    private val _isLoadingStateFlow = MutableStateFlow(true)
    val isLoadingStateFlow = _isLoadingStateFlow.asStateFlow()

    fun checkApplied(courseId: Int) {
        viewModelScope.launch {
            _appliedStateFlow.value =
                getSavedMyCourseListUseCase().first().toMutableList().contains(courseId)
            _isLoadingStateFlow.value = false
        }
    }

    fun singUpCourse(courseId: Int, applied: Boolean) {
        viewModelScope.launch {
            kotlin.runCatching {
                getSavedMyCourseListUseCase()
            }.onSuccess {
                val courseList = it.first().toMutableList()
                if (!applied) courseList.add(courseId)
                else courseList.remove(courseId)
                savedMyCourseListUseCase(courseList.toList())
                _appliedStateFlow.value = !_appliedStateFlow.value
            }.onFailure {
                throw it
            }
        }
    }

    fun getCourseDetail(courseId: Int) {
        viewModelScope.launch {
            _detailCourseStateFlow.value = UiState.Loading
            kotlin.runCatching {
                getCourseDetailUseCase(courseId = courseId)
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
                getCurriculumLectureListUseCase(courseId = courseId, offset = offset, count = count)
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