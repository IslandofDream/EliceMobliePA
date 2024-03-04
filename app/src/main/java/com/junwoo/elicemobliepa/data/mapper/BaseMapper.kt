package com.junwoo.elicemobliepa.data.mapper

interface BaseMapper<From, To> {
    fun map(from: From): To
}