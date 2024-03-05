package com.junwoo.elicemobliepa.domain.entity

class CourseItemEntity(
    val id: Int,
    val imageFileUrl: String?,
    val logoFileUrl: String,
    val title: String,
    val shortDescription: String,
    val tags: List<String?>
)