package com.junwoo.elicemobliepa

import dagger.hilt.android.HiltAndroidApp
import android.app.Application
import timber.log.Timber


@HiltAndroidApp
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}