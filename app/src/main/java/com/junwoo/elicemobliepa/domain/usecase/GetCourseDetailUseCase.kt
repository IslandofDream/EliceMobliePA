package com.junwoo.elicemobliepa.domain.usecase

import com.junwoo.elicemobliepa.core.ApiResult
import com.junwoo.elicemobliepa.domain.entity.CourseDetailEntity
import kotlinx.coroutines.flow.Flow

interface GetCourseDetailUseCase {
    operator fun invoke(courseId: Int): Flow<ApiResult<CourseDetailEntity>>
}