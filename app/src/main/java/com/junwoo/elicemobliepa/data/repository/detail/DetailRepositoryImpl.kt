package com.junwoo.elicemobliepa.data.repository.detail

import com.junwoo.elicemobliepa.core.ApiResult
import com.junwoo.elicemobliepa.data.mapper.CourseDetailMapper
import com.junwoo.elicemobliepa.data.mapper.LectureMapper
import com.junwoo.elicemobliepa.data.remote.DetailCourseDataSource
import com.junwoo.elicemobliepa.domain.entity.CourseDetailEntity
import com.junwoo.elicemobliepa.domain.entity.LectureEntity
import com.junwoo.elicemobliepa.domain.repository.detail.DetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailDataSource: DetailCourseDataSource
) : DetailRepository {
    override fun getCourseDetail(courseId: Int): Flow<ApiResult<CourseDetailEntity>> {
        return flow {
            detailDataSource.getCourseDetail(courseId = courseId).catch {
                emit(ApiResult.Error(it.toString()))
            }.collect {
                emit(ApiResult.Success(CourseDetailMapper().map(it)))
            }
        }
    }

    override fun getLectures(
        courseId: Int,
        offset: Int,
        count: Int
    ): Flow<ApiResult<List<LectureEntity>>> {
        return flow {
            detailDataSource.getLectureList(courseId = courseId, offset = offset, count = count)
                .catch {
                    emit(ApiResult.Error(it.toString()))
                }.collect {
                    emit(ApiResult.Success(LectureMapper().map(it)))
                }
        }
    }
}