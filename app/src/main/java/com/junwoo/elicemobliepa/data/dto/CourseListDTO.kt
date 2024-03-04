package com.junwoo.elicemobliepa.data.dto


import com.google.gson.annotations.SerializedName

data class CourseListDTO(
    @SerializedName("course_count")
    val courseCount: Int?, // 29
    @SerializedName("courses")
    val courses: List<Course?>?,
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
        val beginDatetime: Long?, // 1547462986215
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
        @SerializedName("course_role")
        val courseRole: Int?, // 0
        @SerializedName("course_type")
        val courseType: Int?, // 0
        @SerializedName("discount_begin_datetime")
        val discountBeginDatetime: Long?, // 1709218800000
        @SerializedName("discount_end_datetime")
        val discountEndDatetime: Long?, // 1711897199000
        @SerializedName("discount_rate")
        val discountRate: String?, // 0.2
        @SerializedName("discount_title")
        val discountTitle: String?, // 🌸3월 봄맞이 이벤트🌸
        @SerializedName("discounted_price")
        val discountedPrice: String?, // 0
        @SerializedName("discounted_price_usd")
        val discountedPriceUsd: String?, // 0.00
        @SerializedName("end_datetime")
        val endDatetime: Any?, // null
        @SerializedName("enroll_begin_datetime")
        val enrollBeginDatetime: Long?, // 1547462986215
        @SerializedName("enroll_end_datetime")
        val enrollEndDatetime: Long?, // 1682002800000
        @SerializedName("enroll_limit_number")
        val enrollLimitNumber: Any?, // null
        @SerializedName("enroll_type")
        val enrollType: Int?, // 4
        @SerializedName("enrolled_role_begin_datetime")
        val enrolledRoleBeginDatetime: Any?, // null
        @SerializedName("enrolled_role_brushup_begin_datetime")
        val enrolledRoleBrushupBeginDatetime: Any?, // null
        @SerializedName("enrolled_role_brushup_end_datetime")
        val enrolledRoleBrushupEndDatetime: Any?, // null
        @SerializedName("enrolled_role_end_datetime")
        val enrolledRoleEndDatetime: Any?, // null
        @SerializedName("enrolled_role_period")
        val enrolledRolePeriod: Int?, // 24
        @SerializedName("enrolled_student_count")
        val enrolledStudentCount: Int?, // 0
        @SerializedName("enrolled_user_count")
        val enrolledUserCount: Int?, // 2
        @SerializedName("ern")
        val ern: String?, // ern:core::course/84739
        @SerializedName("has_past_course_role")
        val hasPastCourseRole: Boolean?, // false
        @SerializedName("id")
        val id: Int?, // 84739
        @SerializedName("image_file_url")
        val imageFileUrl: String?, // https://cdn-api.elice.io/api/file/f0b83d1dfd5e47f4b6e8e31753813eeb/%E1%84%8B%E1%85%B0%E1%86%B8_%E1%84%83%E1%85%A9%E1%84%85%E1%85%A6%E1%84%86%E1%85%B52.png?se=2024-03-14T00%3A15%3A00Z&sp=r&sv=2021-12-02&sr=b&sig=%2BbFo3oQfKKD3p7mxa8RPTznKpQgzmWTkwAPXlTxvqWc%3D
        @SerializedName("info_summary_visibility_dict")
        val infoSummaryVisibilityDict: InfoSummaryVisibilityDict?,
        @SerializedName("instructors")
        val instructors: List<Instructor?>?,
        @SerializedName("is_chat_room_disabled")
        val isChatRoomDisabled: Boolean?, // false
        @SerializedName("is_datetime_enrollable")
        val isDatetimeEnrollable: Boolean?, // true
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
        @SerializedName("last_course_info_id")
        val lastCourseInfoId: Int?, // 255861
        @SerializedName("last_review_status")
        val lastReviewStatus: Int?, // 0
        @SerializedName("leaderboard_info")
        val leaderboardInfo: LeaderboardInfo?,
        @SerializedName("leaderboard_ranking_type")
        val leaderboardRankingType: Int?, // 0
        @SerializedName("lecture_page_read_info")
        val lecturePageReadInfo: Any?, // null
        @SerializedName("library_access_type")
        val libraryAccessType: Any?, // null
        @SerializedName("library_credit")
        val libraryCredit: Double?, // 15.0
        @SerializedName("library_type")
        val libraryType: Int?, // 2
        @SerializedName("logo_file_url")
        val logoFileUrl: String?, // https://cdn-api.elice.io/api/file/e8b77f7af0d44cf6bee8c287b471fc5c/algorithm.png?se=2024-03-14T00%3A15%3A00Z&sp=r&sv=2021-12-02&sr=b&sig=pDwE1ZmB9GICClEMHjV326KE7eriGPlolyTdFquqGZA%3D
        @SerializedName("normal_lecture_count")
        val normalLectureCount: Int?, // 5
        @SerializedName("normal_lecture_page_count")
        val normalLecturePageCount: Int?, // 30
        @SerializedName("period")
        val period: Int?, // 4
        @SerializedName("preference")
        val preference: Preference?,
        @SerializedName("prerequisite_course_ids")
        val prerequisiteCourseIds: List<Any?>?,
        @SerializedName("price")
        val price: String?, // 0
        @SerializedName("price_usd")
        val priceUsd: String?, // 0.00
        @SerializedName("promote_video_url")
        val promoteVideoUrl: String?, // https://youtu.be/4ANxB2eXlOc
        @SerializedName("release_datetime")
        val releaseDatetime: Long?, // 1689153998963
        @SerializedName("short_description")
        val shortDescription: String?, // 기술 면접 준비와 개발 역량 강화를 위한 알고리즘 최고 평점 과목 1편!
        @SerializedName("status")
        val status: Int?, // 0
        @SerializedName("subscription_level")
        val subscriptionLevel: Int?, // 10
        @SerializedName("taglist")
        val taglist: List<String?>?,
        @SerializedName("tags")
        val tags: List<Tag?>?,
        @SerializedName("test_lecture")
        val testLecture: Any?, // null
        @SerializedName("test_lecture_count")
        val testLectureCount: Int?, // 1
        @SerializedName("title")
        val title: String?, // 알고리즘의 정석 I
        @SerializedName("tracks")
        val tracks: List<Track?>?,
        @SerializedName("unit")
        val unit: Int?, // 0
        @SerializedName("version")
        val version: Int? // 3
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
            @SerializedName("certificate_info")
            val certificateInfo: CertificateInfo?,
            @SerializedName("condition")
            val condition: Condition?,
            @SerializedName("unit")
            val unit: Unit?
        ) {
            data class CertificateInfo(
                @SerializedName("is_enabled")
                val isEnabled: Boolean?, // false
                @SerializedName("template_id")
                val templateId: String? // 4127d141-be5d-4e41-9d66-ab304de776b2
            )

            data class Condition(
                @SerializedName("is_enabled")
                val isEnabled: Boolean?, // true
                @SerializedName("progress")
                val progress: Int?, // 80
                @SerializedName("score")
                val score: Int? // 400
            )

            data class Unit(
                @SerializedName("is_enabled")
                val isEnabled: Boolean?, // false
                @SerializedName("value")
                val value: Double? // 0.0
            )
        }

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

        data class Instructor(
            @SerializedName("firstname")
            val firstname: String?, // 박상우
            @SerializedName("fullname")
            val fullname: String?, // 박상우
            @SerializedName("id")
            val id: Int?, // 7392106
            @SerializedName("lastname")
            val lastname: String?,
            @SerializedName("profile_url")
            val profileUrl: String? // https://cdn-api.elice.io/api/file/ff6f16bf36da4d50a5ee4839e5d4af6d/account_7089711_profile.jpg?se=2024-03-14T00%3A15%3A00Z&sp=r&sv=2021-12-02&sr=b&sig=abAgfAHj8Kj5e4oH3LJNSTimppYSVDNtfLzsBOXK/x4%3D
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

        data class Preference(
            @SerializedName("attendance")
            val attendance: Boolean?, // true
            @SerializedName("attendance_admin")
            val attendanceAdmin: Boolean?, // true
            @SerializedName("boards")
            val boards: Boolean?, // false
            @SerializedName("chatting")
            val chatting: Boolean?, // false
            @SerializedName("configs")
            val configs: Boolean?, // false
            @SerializedName("dashboard")
            val dashboard: Boolean?, // true
            @SerializedName("helpcenter")
            val helpcenter: Boolean?, // true
            @SerializedName("hide_lecture_pages")
            val hideLecturePages: Boolean?, // true
            @SerializedName("landing")
            val landing: Landing?,
            @SerializedName("leaderboard")
            val leaderboard: Boolean?, // true
            @SerializedName("lectureroom")
            val lectureroom: Boolean?, // false
            @SerializedName("lectures")
            val lectures: Boolean?, // true
            @SerializedName("libraries")
            val libraries: Boolean?, // true
            @SerializedName("live_streaming")
            val liveStreaming: Boolean?, // false
            @SerializedName("manage")
            val manage: Boolean?, // true
            @SerializedName("members")
            val members: Boolean?, // true
            @SerializedName("requests")
            val requests: Boolean?, // true
            @SerializedName("section_schedule")
            val sectionSchedule: Boolean?, // false
            @SerializedName("sections")
            val sections: Boolean?, // true
            @SerializedName("supplement_column_width")
            val supplementColumnWidth: Double?, // 0.7
            @SerializedName("tab_menus_visibility")
            val tabMenusVisibility: TabMenusVisibility?,
            @SerializedName("tutoring")
            val tutoring: Boolean? // true
        ) {
            data class Landing(
                @SerializedName("configs_v2")
                val configsV2: ConfigsV2?,
                @SerializedName("mode")
                val mode: String? // v1
            ) {
                data class ConfigsV2(
                    @SerializedName("ad_banner_image_url")
                    val adBannerImageUrl: String?,
                    @SerializedName("ad_banner_link")
                    val adBannerLink: String?,
                    @SerializedName("bg_color")
                    val bgColor: String?, // {"r":22,"g":54,"b":80,"a":1}
                    @SerializedName("cover_image_url")
                    val coverImageUrl: String?, // https://cdn-api.elice.io/api-attachment/attachment/9c5920fe6ffc49cbbafe6b1c86ccbfa4/%E1%84%8E%E1%85%AC%E1%84%89%E1%85%A1%E1%86%BC%E1%84%83%E1%85%A1%E1%86%AB%20%E1%84%86%E1%85%A6%E1%84%8B%E1%85%B5%E1%86%AB_768_406px.png
                    @SerializedName("promotion_type")
                    val promotionType: String?, // time
                    @SerializedName("sections")
                    val sections: List<Section?>?,
                    @SerializedName("short_description_color")
                    val shortDescriptionColor: String?, // {"r":22,"g":54,"b":80,"a":1}
                    @SerializedName("title_color")
                    val titleColor: String? // {"r":255,"g":255,"b":255,"a":1}
                ) {
                    data class Section(
                        @SerializedName("payload")
                        val payload: Payload?,
                        @SerializedName("type")
                        val type: String?, // textCard
                        @SerializedName("uuid")
                        val uuid: String? // 4a7702a5-101d-4fc7-94b8-10a2744a8541
                    ) {
                        data class Payload(
                            @SerializedName("align_mode")
                            val alignMode: String?, // vertical
                            @SerializedName("anchor_enabled")
                            val anchorEnabled: Boolean?, // false
                            @SerializedName("average_rate")
                            val averageRate: String?, // 4.86
                            @SerializedName("cards")
                            val cards: List<Card?>?,
                            @SerializedName("content")
                            val content: String?, // ![](https://cdn-api.elice.io/api-attachment/attachment/92a30596e7f841f8bacb45b5fb9396a4/%E1%84%92%E1%85%AA%E1%84%86%E1%85%A7%E1%86%AB-%E1%84%80%E1%85%B5%E1%84%85%E1%85%A9%E1%86%A8-2023-05-26-%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE-1.13.58.gif)
                            @SerializedName("description")
                            val description: String?, // <center> <span style="color:blue"> 왕초보도 전문가로! </span> 엘카데미에서 지금 시작하세요.
                            @SerializedName("faqs")
                            val faqs: List<Faq?>?,
                            @SerializedName("file_url")
                            val fileUrl: String?,
                            @SerializedName("label")
                            val label: String?, // 텍스트 카드
                            @SerializedName("objectives")
                            val objectives: List<Objective?>?,
                            @SerializedName("reviews")
                            val reviews: List<Review?>?,
                            @SerializedName("title")
                            val title: String?, //  <center> 시간이 흐를수록 격차는 더 벌어집니다 
                            @SerializedName("visible")
                            val visible: Boolean? // true
                        ) {
                            data class Card(
                                @SerializedName("caption")
                                val caption: String?,
                                @SerializedName("description")
                                val description: String?,
                                @SerializedName("image_url")
                                val imageUrl: String?, // https://cdn-api.elice.io/api-attachment/attachment/cc96dc686dd647cdb9c46c252203a8ce/Slice%201%20%284%29.png
                                @SerializedName("title")
                                val title: String? // <center><span style="color:gray">ONLY ELICE ❶ \n </span>프로그램 설치가 필요없는 \n <span style="color:blue">👩🏻‍💻플랫폼 실습🧑🏻‍💻
                            )

                            data class Faq(
                                @SerializedName("answer")
                                val answer: String?, // A. 알고리즘 퀴즈 칩은 파이썬, 자바, C 등 본인이 원하는 언어로 알고리즘 문제를 푸실 수 있습니다. 하지만, 정답은 파이썬, 자바로 제공되며, 해설은 C언어로만 제공되는 점 참고 부탁드립니다.
                                @SerializedName("question")
                                val question: String? // Q. 알고리즘 언어는 어떻게 구성되어 있나요?
                            )

                            data class Objective(
                                @SerializedName("description")
                                val description: String?,
                                @SerializedName("title")
                                val title: String? // VBA 문법과 사용 방안을 이해합니다.
                            )

                            data class Review(
                                @SerializedName("description")
                                val description: String?,
                                @SerializedName("image_url")
                                val imageUrl: String?, // https://static.elice.io/course/course-manage/user_profile_1.png
                                @SerializedName("title")
                                val title: String?
                            )
                        }
                    }
                }
            }

            data class TabMenusVisibility(
                @SerializedName("attendance")
                val attendance: Boolean?, // true
                @SerializedName("attendance_admin")
                val attendanceAdmin: Boolean?, // true
                @SerializedName("boards")
                val boards: Boolean?, // true
                @SerializedName("configs")
                val configs: Boolean?, // false
                @SerializedName("dashboard")
                val dashboard: Boolean?, // true
                @SerializedName("helpcenter")
                val helpcenter: Boolean?, // true
                @SerializedName("images")
                val images: Boolean?, // true
                @SerializedName("info")
                val info: Boolean?, // true
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
                @SerializedName("requests")
                val requests: Boolean?, // true
                @SerializedName("section_schedule")
                val sectionSchedule: Boolean?, // false
                @SerializedName("sections")
                val sections: Boolean?, // true
                @SerializedName("tutoring")
                val tutoring: Boolean? // true
            )
        }

        data class Tag(
            @SerializedName("id")
            val id: Int?, // 10
            @SerializedName("name")
            val name: String?, // python
            @SerializedName("tag_type")
            val tagType: Int? // 2
        )

        data class Track(
            @SerializedName("id")
            val id: Int?, // 3820
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