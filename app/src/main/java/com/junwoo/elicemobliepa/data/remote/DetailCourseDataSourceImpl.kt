package com.junwoo.elicemobliepa.data.remote

import com.junwoo.elicemobliepa.data.dto.CourseDetailDTO
import com.junwoo.elicemobliepa.data.dto.LectureListDTO
import com.junwoo.elicemobliepa.data.util.safeCallApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailCourseDataSourceImpl @Inject constructor(
    private val eliceApi: EliceApi
) : DetailCourseDataSource {
    override fun getCourseDetail(courseId: Int): Flow<CourseDetailDTO> {
        return flow {
            emit(eliceApi.getCourseDetail(courseId = courseId))
        }.safeCallApi()
    }

    override fun getLectureList(courseId: Int, offset: Int, count: Int): Flow<LectureListDTO> {
        return flow {
            emit(eliceApi.getLectures(courseId = courseId, offset = offset, count = count))
        }.safeCallApi()
    }

}