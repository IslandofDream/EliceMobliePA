package com.junwoo.elicemobliepa.domain.usecase

import com.junwoo.elicemobliepa.core.ApiResult
import com.junwoo.elicemobliepa.domain.entity.LectureEntity
import kotlinx.coroutines.flow.Flow

interface GetCurriculumLectureListUseCase {
    operator fun invoke(courseId: Int, offset: Int, count: Int): Flow<ApiResult<List<LectureEntity>>>
}