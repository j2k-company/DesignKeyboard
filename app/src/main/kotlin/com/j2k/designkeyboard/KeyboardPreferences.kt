package com.j2k.designkeyboard

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.preference.PreferenceManager
import kotlin.reflect.KProperty


class KeyboardPreferences(context: Context) {
    private val resources: Resources = context.resources
    private val preferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    //  keyboard preferences
    var bgColor      by Delegate().Int(resources.getInteger(R.integer.bgColor))

    //  key preferences
    var keyWidth     by Delegate().Int(resources.getInteger(R.integer.keyHeight))
    var keyHeight    by Delegate().Int(resources.getInteger(R.integer.keyWidth))
    var keyTextSize  by Delegate().Int(resources.getInteger(R.integer.keyTextSize))
    var keyTextColor by Delegate().Int(resources.getInteger(R.integer.keyTextColor))
    var keyBgColor   by Delegate().Int(resources.getInteger(R.integer.keyBgColor))


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

    inner class Delegate {
        inner class Int(private val defaultValue: kotlin.Int) {
            operator fun getValue(thisRef: Any?, property: KProperty<*>) =
                read(property.name, defaultValue)

            operator fun setValue(
                thisRef: Any?,
                property: KProperty<*>,
                value: kotlin.Int
            ) {
                write(property.name, value)
            }
        }

        inner class Float(private val defaultValue: kotlin.Float) {
            operator fun getValue(thisRef: Any?, property: KProperty<*>) =
                read(property.name, defaultValue)

            operator fun setValue(
                thisRef: Any?,
                property: KProperty<*>,
                value: kotlin.Float
            ) {
                write(property.name, value)
            }
        }

        inner class String(private val defaultValue: kotlin.String) {
            operator fun getValue(thisRef: Any?, property: KProperty<*>) =
                read(property.name, defaultValue)

            operator fun setValue(
                thisRef: Any?,
                property: KProperty<*>,
                value: kotlin.String
            ) {
                write(property.name, value)
            }
        }

        inner class Boolean(private val defaultValue: kotlin.Boolean) {
            operator fun getValue(thisRef: Any?, property: KProperty<*>) =
                read(property.name, defaultValue)

            operator fun setValue(
                thisRef: Any?,
                property: KProperty<*>,
                value: kotlin.Boolean
            ) {
                write(property.name, value)
            }
        }
    }
}
