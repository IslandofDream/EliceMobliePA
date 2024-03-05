package com.junwoo.elicemobliepa.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetSavedMyCourseListUseCase {
    operator fun invoke(): Flow<List<Int>>
}