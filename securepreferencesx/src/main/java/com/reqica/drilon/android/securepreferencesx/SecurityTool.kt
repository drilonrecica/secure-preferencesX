package com.reqica.drilon.android.securepreferencesx

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

internal object SecurityTool {

    fun getSecurePreferences(context: Context, preferencesFileName: String): SharedPreferences? {
        return EncryptedSharedPreferences.create(
            preferencesFileName,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}