package com.junwoo.elicemobliepa.domain.repository

import com.junwoo.elicemobliepa.core.ApiResult
import com.junwoo.elicemobliepa.domain.entity.CourseDetailEntity
import com.junwoo.elicemobliepa.domain.entity.LectureEntity
import kotlinx.coroutines.flow.Flow

interface DetailRepository {
    fun getCourseDetail(courseId: Int): Flow<ApiResult<CourseDetailEntity>>

    fun getLectures(courseId: Int, offset: Int, count: Int): Flow<ApiResult<List<LectureEntity>>>
}