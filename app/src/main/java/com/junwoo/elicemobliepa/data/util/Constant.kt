package com.junwoo.elicemobliepa.data.util

import androidx.datastore.preferences.core.stringPreferencesKey

object Constant {
    const val APPLICATION_JSON = "application/json"
    const val TIME_OUT = 5L
    const val PAGING_SIZE = 10

    const val DATASTORE_NAME ="my_course"
    val DATASTORE_KEY = stringPreferencesKey("my_course_list")
}