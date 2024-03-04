package com.junwoo.elicemobliepa.domain.repository

import androidx.paging.PagingData
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun fetchCourseItems(
        filterIsRecommended: Boolean? = null,
        filterIsFree: Boolean? = null,
        filterConditions: String? = null
    ): Flow<PagingData<CourseItemEntity>>

}