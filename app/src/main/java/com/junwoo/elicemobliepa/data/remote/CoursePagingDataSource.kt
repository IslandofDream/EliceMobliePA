package com.junwoo.elicemobliepa.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.junwoo.elicemobliepa.data.mapper.CourseListMapper
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity

class CoursePagingSource(
    private val service: EliceApi,
    private val filterIsRecommended: Boolean? = null,
    private val filterIsFree: Boolean? = null,
    private val filterConditions: String? = null,
    private val courseListMapper: CourseListMapper
) : PagingSource<Int, CourseItemEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CourseItemEntity> {
        return try {
            val position = params.key ?: STARTING_PAGE_INDEX
            val response = service.getCourses(
                offset = position,
                count = params.loadSize,
                filterIsRecommended = filterIsRecommended,
                filterIsFree = filterIsFree,
                filterConditions = filterConditions
            ).let {
                courseListMapper.map(it)
            }

            LoadResult.Page(
                data = response,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - params.loadSize,
                nextKey = if (response.isEmpty()) null else position + params.loadSize
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CourseItemEntity>): Int? {
        return state.anchorPosition
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 0
    }
}