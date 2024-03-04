package com.junwoo.elicemobliepa.data.dto


import com.google.gson.annotations.SerializedName

data class CourseDetailDTO(
    @SerializedName("course")
    val course: Course?,
    @SerializedName("course_role")
    val courseRole: Int?, // 0
    @SerializedName("course_sections")
    val courseSections: List<Any?>?,
    @SerializedName("has_past_course_role")
    val hasPastCourseRole: Boolean?, // false
    @SerializedName("_result")
    val result: Result?
) {
    data class Course(
        @SerializedName("agreement_info")
        val agreementInfo: AgreementInfo?,
        @SerializedName("aibot_info")
        val aibotInfo: AibotInfo?,
        @SerializedName("attend_info")
        val attendInfo: AttendInfo?,
        @SerializedName("begin_datetime")
        val beginDatetime: Long?, // 1640962800000
        @SerializedName("brushup_info")
        val brushupInfo: Any?, // null
        @SerializedName("class_times")
        val classTimes: List<Any?>?,
        @SerializedName("class_type")
        val classType: Int?, // 0
        @SerializedName("code")
        val code: String?,
        @SerializedName("complete_datetime")
        val completeDatetime: Any?, // null
        @SerializedName("completion_info")
        val completionInfo: CompletionInfo?,
        @SerializedName("course_agreed_datetime")
        val courseAgreedDatetime: Any?, // null
        @SerializedName("course_info_created_datetime")
        val courseInfoCreatedDatetime: Long?, // 1706768446257
        @SerializedName("course_info_id")
        val courseInfoId: Int?, // 264514
        @SerializedName("course_info_user")
        val courseInfoUser: CourseInfoUser?,
        @SerializedName("course_type")
        val courseType: Int?, // 0
        @SerializedName("created_datetime")
        val createdDatetime: Long?, // 1641450294180
        @SerializedName("description")
        val description: String?, // ### **파이썬 기초에서 한 걸음 더! 배운 것을 응용하는 법을 배워요.**파이썬의 기초 자료형, 조건문, 리스트와 반복문을 배우셨나요? 이번에는 코드를 짜는 데에 어떻게 이들을 활용하는지 배워봅시다! 더 많은 파이썬의 자료형에서부터 객체 지향 프로그래밍에 대한 기본 개념까지 학습해봐요. <br>### **실습을 통해 파이썬 함수와 자연스레 친해지세요.**프로그래밍에서 정~말 중요한 함수. 함수를 사용하면 반복되는 작업을 하지 않아도 될 뿐만 아니라 프로그램을 한눈에 파악하기 좋아져요. 이 과목에서는 직접 함수를 만들고 만든 함수를 모듈에 저장해 불러오는 법을 실습을 통해 익힙니다. 출퇴근길, 등하굣길 30분씩만 실습에 투자하면 자연스레 함수와 친해질 수 있어요. 유능한 프로그래머에 한 걸음 더 가까워지세요! <br>### **객체지향 프로그래밍을 위한 디딤돌!**빅데이터 시대에 더욱 중요한 '객체'! 효율적으로 데이터를 처리하기 위해서는 각자의 역할을 수행하는 '객체'가 꼭 필요해요. 이 과목에서 객체지향 프로그래밍의 기본 개념을 익히고 객체지향 프로그래밍을 위한 기초 체력을 탄탄히 해보세요!
        @SerializedName("discount_begin_datetime")
        val discountBeginDatetime: Any?, // null
        @SerializedName("discount_end_datetime")
        val discountEndDatetime: Any?, // null
        @SerializedName("discount_rate")
        val discountRate: Any?, // null
        @SerializedName("discount_title")
        val discountTitle: Any?, // null
        @SerializedName("discounted_price")
        val discountedPrice: String?, // 119000
        @SerializedName("discounted_price_usd")
        val discountedPriceUsd: String?, // 99.17
        @SerializedName("end_datetime")
        val endDatetime: Any?, // null
        @SerializedName("enroll_begin_datetime")
        val enrollBeginDatetime: Long?, // 1640962800000
        @SerializedName("enroll_end_datetime")
        val enrollEndDatetime: Long?, // 1689087600000
        @SerializedName("enroll_limit_number")
        val enrollLimitNumber: Any?, // null
        @SerializedName("enroll_type")
        val enrollType: Int?, // 5
        @SerializedName("enrolled_role_period")
        val enrolledRolePeriod: Int?, // 12
        @SerializedName("enrolled_student_count")
        val enrolledStudentCount: Int?, // 2
        @SerializedName("enrolled_user_count")
        val enrolledUserCount: Int?, // 25
        @SerializedName("ern")
        val ern: String?, // ern:core::course/18817
        @SerializedName("exercise_page_count")
        val exercisePageCount: Int?, // 32
        @SerializedName("faq")
        val faq: List<Any?>?,
        @SerializedName("head_tas")
        val headTas: List<Any?>?,
        @SerializedName("id")
        val id: Int?, // 18817
        @SerializedName("image_file_url")
        val imageFileUrl: String?, // https://cdn-api.elice.io/api/file/aecd57d0cc7d44c790404fe89c777928/%E1%84%83%E1%85%A9%E1%84%85%E1%85%A6%E1%84%86%E1%85%B5%E1%84%91%E1%85%A1%E1%84%8B%E1%85%B5%E1%84%8A%E1%85%A5%E1%86%AB2.png?se=2024-03-14T00%3A15%3A00Z&sp=r&sv=2021-12-02&sr=b&sig=QKd7CQOJ9GUVgJOBuUkwVooGKuEwEYwxT%2BJzhw%2B34bo%3D
        @SerializedName("info_summary_visibility_dict")
        val infoSummaryVisibilityDict: InfoSummaryVisibilityDict?,
        @SerializedName("instructors")
        val instructors: List<Any?>?,
        @SerializedName("is_chat_room_disabled")
        val isChatRoomDisabled: Boolean?, // true
        @SerializedName("is_course_library")
        val isCourseLibrary: Any?, // null
        @SerializedName("is_datetime_enrollable")
        val isDatetimeEnrollable: Boolean?, // false
        @SerializedName("is_discounted")
        val isDiscounted: Boolean?, // false
        @SerializedName("is_enroll_guest_enabled")
        val isEnrollGuestEnabled: Boolean?, // false
        @SerializedName("is_enroll_noti_enabled")
        val isEnrollNotiEnabled: Boolean?, // false
        @SerializedName("is_exercise_deprecated")
        val isExerciseDeprecated: Boolean?, // false
        @SerializedName("is_free")
        val isFree: Boolean?, // false
        @SerializedName("is_legacy_test")
        val isLegacyTest: Boolean?, // true
        @SerializedName("is_library_material_instance_exist")
        val isLibraryMaterialInstanceExist: Boolean?, // false
        @SerializedName("is_library_material_instance_sync_enabled")
        val isLibraryMaterialInstanceSyncEnabled: Boolean?, // false
        @SerializedName("is_lms_course")
        val isLmsCourse: Boolean?, // false
        @SerializedName("is_material_library")
        val isMaterialLibrary: Any?, // null
        @SerializedName("is_origin_library_sync_enabled")
        val isOriginLibrarySyncEnabled: Boolean?, // true
        @SerializedName("is_phone_verify_required")
        val isPhoneVerifyRequired: Boolean?, // false
        @SerializedName("is_post_student_email_enabled")
        val isPostStudentEmailEnabled: Boolean?, // false
        @SerializedName("is_post_student_info_visible")
        val isPostStudentInfoVisible: Boolean?, // false
        @SerializedName("is_post_tutor_email_enabled")
        val isPostTutorEmailEnabled: Boolean?, // false
        @SerializedName("is_recommended")
        val isRecommended: Boolean?, // true
        @SerializedName("last_attend_updated_date")
        val lastAttendUpdatedDate: Any?, // null
        @SerializedName("last_library_version_status")
        val lastLibraryVersionStatus: Any?, // null
        @SerializedName("last_review_status")
        val lastReviewStatus: Int?, // 3
        @SerializedName("leaderboard_info")
        val leaderboardInfo: LeaderboardInfo?,
        @SerializedName("leaderboard_ranking_type")
        val leaderboardRankingType: Int?, // 0
        @SerializedName("lectures")
        val lectures: List<Any?>?,
        @SerializedName("library_access_type")
        val libraryAccessType: Any?, // null
        @SerializedName("library_credit")
        val libraryCredit: Any?, // null
        @SerializedName("library_status")
        val libraryStatus: Any?, // null
        @SerializedName("library_type")
        val libraryType: Int?, // 2
        @SerializedName("logo_file_url")
        val logoFileUrl: String?, // https://cdn-api.elice.io/api/file/597b9ecbe8fb4cd7ac567d5c9a3f8759/python_02.png?se=2024-03-14T00%3A15%3A00Z&sp=r&sv=2021-12-02&sr=b&sig=eG9THKfdg%2B5QR4/Q0HznqVGq9XA2AvP9cksn4Rc9SAU%3D
        @SerializedName("modified_datetime")
        val modifiedDatetime: Long?, // 1706768446264
        @SerializedName("normal_lecture_count")
        val normalLectureCount: Int?, // 5
        @SerializedName("normal_lecture_page_count")
        val normalLecturePageCount: Int?, // 61
        @SerializedName("objective")
        val objective: List<String?>?,
        @SerializedName("organization_id")
        val organizationId: Int?, // 1009
        @SerializedName("origin_course")
        val originCourse: OriginCourse?,
        @SerializedName("origin_library_synced_datetime")
        val originLibrarySyncedDatetime: Long?, // 1665997489056
        @SerializedName("origin_library_version_name")
        val originLibraryVersionName: Int?, // 5
        @SerializedName("period")
        val period: Int?, // 4
        @SerializedName("preference")
        val preference: Preference?,
        @SerializedName("prerequisite_course_ids")
        val prerequisiteCourseIds: List<Any?>?,
        @SerializedName("price")
        val price: String?, // 119000
        @SerializedName("price_usd")
        val priceUsd: String?, // 99.17
        @SerializedName("product_uid")
        val productUid: String?, // /service:eliceapi/product_type:course/product_id:18817/
        @SerializedName("promote_video_url")
        val promoteVideoUrl: Any?, // null
        @SerializedName("release_datetime")
        val releaseDatetime: Long?, // 1641521741515
        @SerializedName("short_description")
        val shortDescription: String?, // 매주 다양하고 유익한 실습으로 재미있게 배우는 코딩 기초 반!
        @SerializedName("status")
        val status: Int?, // 3
        @SerializedName("subscription_level")
        val subscriptionLevel: Any?, // null
        @SerializedName("syllabus_url")
        val syllabusUrl: Any?, // null
        @SerializedName("taglist")
        val taglist: List<String?>?,
        @SerializedName("tags")
        val tags: List<Any?>?,
        @SerializedName("target_audience")
        val targetAudience: List<TargetAudience?>?,
        @SerializedName("tas")
        val tas: List<Any?>?,
        @SerializedName("test_lecture")
        val testLecture: Any?, // null
        @SerializedName("test_lecture_count")
        val testLectureCount: Int?, // 1
        @SerializedName("title")
        val title: String?, // 도레미 파이썬 Vol.2
        @SerializedName("total_video_duration")
        val totalVideoDuration: Int?, // 8543
        @SerializedName("tracks")
        val tracks: List<Track?>?,
        @SerializedName("unit")
        val unit: Any?, // null
        @SerializedName("version")
        val version: Int? // 27
    ) {
        data class AgreementInfo(
            @SerializedName("description")
            val description: String?,
            @SerializedName("is_enabled")
            val isEnabled: Boolean?, // false
            @SerializedName("title")
            val title: String?
        )

        data class AibotInfo(
            @SerializedName("is_enabled")
            val isEnabled: Boolean? // true
        )

        data class AttendInfo(
            @SerializedName("active_begin_date")
            val activeBeginDate: String?, // 0001-01-01
            @SerializedName("active_end_date")
            val activeEndDate: String?, // 0001-01-01
            @SerializedName("check_in_begin_time")
            val checkInBeginTime: String?, // 00:00
            @SerializedName("check_in_end_time")
            val checkInEndTime: String?, // 24:00
            @SerializedName("check_out_begin_time")
            val checkOutBeginTime: String?, // 00:00
            @SerializedName("check_out_end_time")
            val checkOutEndTime: String?, // 24:00
            @SerializedName("is_enabled")
            val isEnabled: Boolean?, // false
            @SerializedName("required_stay_seconds")
            val requiredStaySeconds: Int? // 0
        )

        data class CompletionInfo(
            @SerializedName("condition")
            val condition: Condition?,
            @SerializedName("unit")
            val unit: Unit?
        ) {
            data class Condition(
                @SerializedName("is_enabled")
                val isEnabled: Boolean?, // true
                @SerializedName("progress")
                val progress: Int?, // 80
                @SerializedName("score")
                val score: Int? // 60
            )

            data class Unit(
                @SerializedName("is_enabled")
                val isEnabled: Boolean?, // false
                @SerializedName("value")
                val value: Double? // 0.0
            )
        }

        data class CourseInfoUser(
            @SerializedName("firstname")
            val firstname: String?, // 조수아
            @SerializedName("fullname")
            val fullname: String?, // 조수아
            @SerializedName("id")
            val id: Int?, // 15297378
            @SerializedName("lastname")
            val lastname: String?,
            @SerializedName("profile_url")
            val profileUrl: Any? // null
        )

        data class InfoSummaryVisibilityDict(
            @SerializedName("class_times")
            val classTimes: Boolean?, // false
            @SerializedName("class_type")
            val classType: Boolean?, // true
            @SerializedName("completion_condition")
            val completionCondition: Boolean?, // true
            @SerializedName("completion_unit")
            val completionUnit: Boolean?, // false
            @SerializedName("enrolled_student_count")
            val enrolledStudentCount: Boolean?, // true
            @SerializedName("exercise_page_count")
            val exercisePageCount: Boolean?, // true
            @SerializedName("lecture_page_access_period")
            val lecturePageAccessPeriod: Boolean?, // true
            @SerializedName("level")
            val level: Boolean?, // true
            @SerializedName("period")
            val period: Boolean?, // false
            @SerializedName("programming_language")
            val programmingLanguage: Boolean?, // true
            @SerializedName("total_video_duration")
            val totalVideoDuration: Boolean? // true
        )

        data class LeaderboardInfo(
            @SerializedName("entry_type")
            val entryType: Int?, // 0
            @SerializedName("ranking_type")
            val rankingType: Int?, // 0
            @SerializedName("score_open_datetime")
            val scoreOpenDatetime: Any?, // null
            @SerializedName("score_ratio")
            val scoreRatio: Any?, // null
            @SerializedName("score_type")
            val scoreType: Int?, // 0
            @SerializedName("submit_count_limit")
            val submitCountLimit: Any? // null
        )

        data class OriginCourse(
            @SerializedName("id")
            val id: Int?, // 18389
            @SerializedName("organization")
            val organization: Organization?,
            @SerializedName("title")
            val title: String? // 2022 도레미 파이썬 Vol.2
        ) {
            data class Organization(
                @SerializedName("id")
                val id: Int?, // 875
                @SerializedName("name")
                val name: String?, // 엘리스 라이브러리
                @SerializedName("name_short")
                val nameShort: String? // elice-library
            )
        }

        data class Preference(
            @SerializedName("live_streaming")
            val liveStreaming: Boolean?, // false
            @SerializedName("tab_menus_visibility")
            val tabMenusVisibility: TabMenusVisibility?
        ) {
            data class TabMenusVisibility(
                @SerializedName("boards")
                val boards: Boolean?, // true
                @SerializedName("configs")
                val configs: Boolean?, // false
                @SerializedName("dashboard")
                val dashboard: Boolean?, // true
                @SerializedName("leaderboard")
                val leaderboard: Boolean?, // true
                @SerializedName("lectureroom")
                val lectureroom: Boolean?, // false
                @SerializedName("lectures")
                val lectures: Boolean?, // true
                @SerializedName("libraries")
                val libraries: Boolean?, // true
                @SerializedName("manage")
                val manage: Boolean?, // true
                @SerializedName("members")
                val members: Boolean?, // true
                @SerializedName("section_schedule")
                val sectionSchedule: Boolean?, // false
                @SerializedName("sections")
                val sections: Boolean?, // true
                @SerializedName("tutoring")
                val tutoring: Boolean? // true
            )
        }

        data class TargetAudience(
            @SerializedName("description")
            val description: String?, // 프로그래밍을 배우려고 하는데 이왕이면 재밌고 쉽게 배우고 싶으신 분
            @SerializedName("image")
            val image: String?, // /imgs/course/target_img_01.png
            @SerializedName("title")
            val title: String? // 코딩 입문자
        )

        data class Track(
            @SerializedName("id")
            val id: Int?, // 1832
            @SerializedName("title")
            val title: String? // 가장 빠른 파이썬 기초 정복
        )
    }

    data class Result(
        @SerializedName("reason")
        val reason: Any?, // null
        @SerializedName("status")
        val status: String? // ok
    )
}