package com.reqica.drilon.android.securepreferencesxsample

import android.app.Application
import com.reqica.drilon.android.securepreferencesx.SecurePreferences

@Suppress("unused")
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SecurePreferences.initSecurePreferences(packageName, "SecurePreferencesFileName")
    }
}