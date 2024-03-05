package com.junwoo.elicemobliepa.data.mapper

import com.junwoo.elicemobliepa.data.dto.CourseListDTO
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import okhttp3.internal.toImmutableList

class CourseListMapper : BaseMapper<CourseListDTO, List<CourseItemEntity>> {
    override fun map(from: CourseListDTO): List<CourseItemEntity> =
        from.courses?.let {
            it.asSequence().map { field ->
                CourseItemEntity(
                    id = field?.id ?: 0,
                    imageFileUrl = field?.imageFileUrl,
                    logoFileUrl = field?.logoFileUrl ?: "",
                    title = field?.title ?: "",
                    shortDescription = field?.shortDescription ?: "",
                    tags = field?.tags?.map { tag -> tag?.name }?.toImmutableList() ?: listOf()
                )
            }
        }?.toList() ?: listOf()
}

