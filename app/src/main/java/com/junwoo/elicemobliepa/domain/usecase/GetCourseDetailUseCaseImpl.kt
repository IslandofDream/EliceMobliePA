package com.junwoo.elicemobliepa.domain.usecase

import com.junwoo.elicemobliepa.core.ApiResult
import com.junwoo.elicemobliepa.domain.entity.CourseDetailEntity
import com.junwoo.elicemobliepa.domain.repository.detail.DetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCourseDetailUseCaseImpl @Inject constructor(private val detailRepository: DetailRepository) :
    GetCourseDetailUseCase {
    override fun invoke(courseId: Int): Flow<ApiResult<CourseDetailEntity>> {
        return detailRepository.getCourseDetail(courseId = courseId)
    }
}