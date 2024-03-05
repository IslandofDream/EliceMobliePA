package com.junwoo.elicemobliepa.data.mapper

import com.junwoo.elicemobliepa.data.dto.CourseDetailDTO
import com.junwoo.elicemobliepa.domain.entity.CourseDetailEntity

class CourseDetailMapper : BaseMapper<CourseDetailDTO, CourseDetailEntity> {
    override fun map(from: CourseDetailDTO): CourseDetailEntity {
        return from.course!!.let {
            CourseDetailEntity(
                imageUrl = it.imageFileUrl,
                logoUrl = it.logoFileUrl ?: "o",
                description = it.description,
                title = it.title ?: "",
                shortDescription = it.shortDescription
            )
        }
    }
}