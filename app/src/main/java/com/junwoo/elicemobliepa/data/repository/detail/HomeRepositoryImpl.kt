package com.junwoo.elicemobliepa.data.repository.detail

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.google.gson.Gson
import com.junwoo.elicemobliepa.data.mapper.CourseListMapper
import com.junwoo.elicemobliepa.data.remote.CoursePagingSource
import com.junwoo.elicemobliepa.data.remote.EliceApi
import com.junwoo.elicemobliepa.data.util.Constant
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import com.junwoo.elicemobliepa.domain.repository.home.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val eliceService: EliceApi,
    private val gson: Gson
) : HomeRepository {

    override fun fetchCourseItems(
        filterIsRecommended: Boolean?,
        filterIsFree: Boolean?,
        filterConditions: List<Int>?
    ): Flow<PagingData<CourseItemEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constant.PAGING_SIZE,
                initialLoadSize = Constant.PAGING_SIZE
            ),
            pagingSourceFactory = {
                val filterConditionQuery = filterConditions?.let {
                    gson.toJson(mapOf("course_ids" to filterConditions))
                }
                CoursePagingSource(
                    service = eliceService,
                    filterIsRecommended = filterIsRecommended,
                    filterIsFree = filterIsFree,
                    filterConditions = filterConditionQuery,
                    CourseListMapper()
                )
            }
        ).flow
    }

}