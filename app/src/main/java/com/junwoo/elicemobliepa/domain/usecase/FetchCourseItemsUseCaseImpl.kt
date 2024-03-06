package com.junwoo.elicemobliepa.domain.usecase

import androidx.paging.PagingData
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import com.junwoo.elicemobliepa.domain.repository.home.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchCourseItemsUseCaseImpl @Inject constructor(private val homeRepository: HomeRepository) :
    FetchCourseItemsUseCase {
    override fun invoke(
        filterIsRecommended: Boolean?,
        filterIsFree: Boolean?,
        filterConditions: List<Int>?
    ): Flow<PagingData<CourseItemEntity>> {
        return homeRepository.fetchCourseItems(
            filterIsRecommended = filterIsRecommended,
            filterIsFree = filterIsFree,
            filterConditions = filterConditions
        )
    }
}