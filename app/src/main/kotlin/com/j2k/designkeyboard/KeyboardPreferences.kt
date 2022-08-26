package com.j2k.designkeyboard

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.preference.PreferenceManager


class KeyboardPreferences(context: Context) {
    private val resources: Resources = context.resources
    private val preferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    // write preference
    @SuppressLint("CommitPrefEdits")
    private fun write(key: String, value: Int) {
        preferences.edit()
            .putInt(key, value)
            .apply()
    }
    @SuppressLint("CommitPrefEdits")
    private fun write(key: String, value: Float) {
        preferences.edit()
            .putFloat(key, value)
            .apply()
    }
    @SuppressLint("CommitPrefEdits")
    private fun write(key: String, value: String) {
        preferences.edit()
            .putString(key, value)
            .apply()
    }
    @SuppressLint("CommitPrefEdits")
    private fun write(key: String, value: Boolean) {
        preferences.edit()
            .putBoolean(key, value)
            .apply()
    }

    // read preference
    private fun read(key: String, defaultValue: Int) =
        preferences.getInt(key, defaultValue)
    private fun read(key: String, defaultValue: Float) =
        preferences.getFloat(key, defaultValue)
    private fun read(key: String, defaultValue: String) =
        preferences.getString(key, defaultValue)
    private fun read(key: String, defaultValue: Boolean) =
        preferences.getBoolean(key, defaultValue)
}