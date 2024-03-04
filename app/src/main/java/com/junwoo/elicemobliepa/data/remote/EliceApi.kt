package com.junwoo.elicemobliepa.data.remote

import com.junwoo.elicemobliepa.data.dto.CourseDetailDTO
import com.junwoo.elicemobliepa.data.dto.CourseListDTO
import com.junwoo.elicemobliepa.data.dto.LectureListDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface EliceApi {

    @GET("course/list/")
    suspend fun getCourses(
        @Query("offset") offset: Int,
        @Query("count") count: Int,
        @Query("filter_is_recommended") filterIsRecommended: Boolean? = null,
        @Query("filter_is_free") filterIsFree: Boolean? = null,
        @Query("filter_conditions") filterConditions: String? = null // JSON String
    ): CourseListDTO

    @GET("course/get/")
    suspend fun getCourseDetail(
        @Query("course_id") courseId: Int
    ): CourseDetailDTO

    @GET("lecture/list/")
    suspend fun getLectures(
        @Query("course_id") courseId: Int,
        @Query("offset") offset: Int,
        @Query("count") count: Int
    ): LectureListDTO

}