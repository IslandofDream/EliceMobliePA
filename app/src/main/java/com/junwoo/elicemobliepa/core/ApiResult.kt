package com.junwoo.elicemobliepa.core

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error<T>(val message: String) : ApiResult<T>()
}