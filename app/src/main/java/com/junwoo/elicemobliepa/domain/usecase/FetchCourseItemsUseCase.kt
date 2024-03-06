package com.junwoo.elicemobliepa.domain.usecase

import androidx.paging.PagingData
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import kotlinx.coroutines.flow.Flow

interface FetchCourseItemsUseCase {
    operator fun invoke(
        filterIsRecommended: Boolean? = null,
        filterIsFree: Boolean? = null,
        filterConditions: List<Int>? = null
    ) : Flow<PagingData<CourseItemEntity>>
}