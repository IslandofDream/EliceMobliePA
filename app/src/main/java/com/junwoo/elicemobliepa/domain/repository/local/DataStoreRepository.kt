package com.junwoo.elicemobliepa.domain.repository.local

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun saveMyCourseList(list: List<Int>)

    fun getMyCourseList(): Flow<List<Int>>
}