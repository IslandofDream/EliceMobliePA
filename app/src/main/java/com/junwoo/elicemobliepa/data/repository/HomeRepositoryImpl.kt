package com.junwoo.elicemobliepa.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.junwoo.elicemobliepa.data.mapper.CourseListMapper
import com.junwoo.elicemobliepa.data.remote.CoursePagingSource
import com.junwoo.elicemobliepa.data.remote.EliceApi
import com.junwoo.elicemobliepa.data.util.Constant
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import com.junwoo.elicemobliepa.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val eliceService: EliceApi
) : HomeRepository {

    override fun fetchCourseItems(
        filterIsRecommended: Boolean?,
        filterIsFree: Boolean?,
        filterConditions: String?
    ): Flow<PagingData<CourseItemEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constant.PAGING_SIZE,
            ),
            pagingSourceFactory = {
                CoursePagingSource(
                    service = eliceService,
                    filterIsRecommended = filterIsRecommended,
                    filterIsFree = filterIsFree,
                    filterConditions = filterConditions,
                    CourseListMapper()
                )
            }
        ).flow
    }
}