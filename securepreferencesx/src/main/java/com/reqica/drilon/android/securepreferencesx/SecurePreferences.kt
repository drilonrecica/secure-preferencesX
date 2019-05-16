package com.reqica.drilon.android.securepreferencesx

import android.content.Context
import com.reqica.drilon.android.securepreferenceslibrary.R
import java.lang.NullPointerException

object SecurePreferences {
    var preferencesFileName: String? = null

    fun initSecurePreferences(packageName: String, preferencesFileName: String) {
        SecurePreferences.preferencesFileName = packageName + preferencesFileName
    }

    @Throws(NullPointerException::class)
    fun storeValue(context: Context, key: String, value: String) {
        if (preferencesFileName.isNullOrEmpty()) {
            throw NullPointerException(context.getString(R.string.error_message_preferencesFileName_null_or_empty))
        } else {
            val securePreferences = SecurityTool.getSecurePreferences(
                context,
                preferencesFileName!!
            )
            val editor = securePreferences?.edit()
            editor?.putString(key, value)?.apply()
        }
    }

    @Throws(NullPointerException::class)
    fun retrieveValue(context: Context, key: String, defaultValue: String?): String? {
        return if (preferencesFileName.isNullOrEmpty()) {
            throw NullPointerException(context.getString(R.string.error_message_preferencesFileName_null_or_empty))
        } else {
            SecurityTool.getSecurePreferences(
                context,
                preferencesFileName!!
            )?.getString(key, defaultValue)
        }
    }
}