package com.junwoo.elicemobliepa.data.remote

import com.junwoo.elicemobliepa.data.dto.CourseDetailDTO
import com.junwoo.elicemobliepa.data.dto.LectureListDTO
import kotlinx.coroutines.flow.Flow

interface DetailCourseDataSource {

    fun getCourseDetail(courseId: Int): Flow<CourseDetailDTO>

    fun getLectureList(courseId: Int, offset: Int, count: Int): Flow<LectureListDTO>

}