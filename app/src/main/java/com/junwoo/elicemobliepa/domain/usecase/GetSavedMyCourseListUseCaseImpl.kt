package com.junwoo.elicemobliepa.domain.usecase

import com.junwoo.elicemobliepa.domain.repository.local.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedMyCourseListUseCaseImpl @Inject constructor(private val dataStoreRepository: DataStoreRepository) :
    GetSavedMyCourseListUseCase {
    override fun invoke(): Flow<List<Int>> {
        return dataStoreRepository.getMyCourseList()
    }
}