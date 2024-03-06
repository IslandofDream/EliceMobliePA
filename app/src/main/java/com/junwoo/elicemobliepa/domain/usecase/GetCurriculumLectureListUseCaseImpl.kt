package com.junwoo.elicemobliepa.domain.usecase

import com.junwoo.elicemobliepa.core.ApiResult
import com.junwoo.elicemobliepa.domain.entity.LectureEntity
import com.junwoo.elicemobliepa.domain.repository.detail.DetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurriculumLectureListUseCaseImpl @Inject constructor(private val detailRepository: DetailRepository) :
    GetCurriculumLectureListUseCase {
    override fun invoke(
        courseId: Int,
        offset: Int,
        count: Int
    ): Flow<ApiResult<List<LectureEntity>>> {
        return detailRepository.getLectures(courseId = courseId, offset = offset, count = count)
    }
}