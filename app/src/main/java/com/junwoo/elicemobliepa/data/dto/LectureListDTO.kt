package com.junwoo.elicemobliepa.data.dto


import com.google.gson.annotations.SerializedName

data class LectureListDTO(
    @SerializedName("lecture_count")
    val lectureCount: Int?, // 6
    @SerializedName("lectures")
    val lectures: List<Lecture?>?,
    @SerializedName("_result")
    val result: Result?
) {
    data class Lecture(
        @SerializedName("cheat_info")
        val cheatInfo: Any?, // null
        @SerializedName("close_schedule_datetime")
        val closeScheduleDatetime: Any?, // null
        @SerializedName("description")
        val description: String?, // 도레미 파이썬!의 미리보기 실습 문제를 풀어보세요!
        @SerializedName("id")
        val id: Int?, // 153390
        @SerializedName("is_opened")
        val isOpened: Boolean?, // true
        @SerializedName("is_preview")
        val isPreview: Boolean?, // true
        @SerializedName("is_test_accessible_after_completion")
        val isTestAccessibleAfterCompletion: Boolean?, // false
        @SerializedName("is_test_reset_enabled_by_student")
        val isTestResetEnabledByStudent: Any?, // null
        @SerializedName("is_test_score_opened")
        val isTestScoreOpened: Boolean?, // true
        @SerializedName("lecture_group_total_point")
        val lectureGroupTotalPoint: Any?, // null
        @SerializedName("lecture_type")
        val lectureType: Int?, // 0
        @SerializedName("open_schedule_datetime")
        val openScheduleDatetime: Any?, // null
        @SerializedName("order_no")
        val orderNo: Int?, // 1
        @SerializedName("teaching_datetime")
        val teachingDatetime: Any?, // null
        @SerializedName("test_begin_datetime")
        val testBeginDatetime: Long?, // 1548760894864
        @SerializedName("test_description")
        val testDescription: String?, // 1.	테스트 조건을 충분히 숙지한 후 응시하기 버튼을 클릭하여 테스트를 시작하세요.2.	테스트를 시작하면 제한 시간을 멈출 수 없으며 주어진 시간 안에 모든 문제를 풀어야 합니다.3.	테스트 도중 페이지 이탈 시 제출 이력 및 작성한 코드는 저장되며 제한 시간은 계속 진행됩니다.4.	문제를 모두 푼 후 반드시 테스트 완료하기 버튼을 클릭하세요. 미클릭 시 모든 문항이 미제출 처리됩니다.5.	모든 프로그래밍 문제는 마지막 제출한 코드 기준으로 채점됩니다.6.	모든 퀴즈는 마지막 저장한 답안 기준으로 채점됩니다.7.	부정행위 적발 시 0점 처리됩니다.
        @SerializedName("test_duration")
        val testDuration: Any?, // null
        @SerializedName("test_end_datetime")
        val testEndDatetime: Any?, // null
        @SerializedName("test_qualification")
        val testQualification: Any?, // null
        @SerializedName("test_score_open_datetime")
        val testScoreOpenDatetime: Any?, // null
        @SerializedName("title")
        val title: String?, // 수업 미리보기
        @SerializedName("total_page_count")
        val totalPageCount: Int?, // 0
        @SerializedName("total_page_point")
        val totalPagePoint: Int? // 0
    )

    data class Result(
        @SerializedName("reason")
        val reason: Any?, // null
        @SerializedName("status")
        val status: String? // ok
    )
}