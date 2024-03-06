package com.junwoo.elicemobliepa.domain.usecase

import com.junwoo.elicemobliepa.domain.repository.datastore.DataStoreRepository
import javax.inject.Inject

class SaveMyCourseListUseCaseImpl @Inject constructor(private val dataStoreRepository: DataStoreRepository) :
    SaveMyCourseListUseCase {
    override suspend fun invoke(list: List<Int>) {
        dataStoreRepository.saveMyCourseList(list = list)
    }
}