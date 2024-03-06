package com.junwoo.elicemobliepa.domain.usecase

interface SaveMyCourseListUseCase {
    suspend operator fun invoke(list: List<Int>)
}