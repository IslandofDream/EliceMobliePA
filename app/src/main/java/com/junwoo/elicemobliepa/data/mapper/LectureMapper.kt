package com.junwoo.elicemobliepa.data.mapper

import com.junwoo.elicemobliepa.data.dto.LectureListDTO
import com.junwoo.elicemobliepa.domain.entity.LectureEntity

class LectureMapper : BaseMapper<LectureListDTO, List<LectureEntity>> {
    override fun map(from: LectureListDTO): List<LectureEntity> =
        from.lectures?.let { it ->
            it.asSequence().map { field ->
                LectureEntity(
                    title = field?.title,
                    description = field?.description
                )
            }
        }?.toList() ?: listOf()
}