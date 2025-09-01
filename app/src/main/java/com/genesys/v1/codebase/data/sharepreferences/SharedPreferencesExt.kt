package com.genesys.v1.codebase.data.sharepreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LifecycleOwner

object SharedPreferencesExt {
    private const val KEY_SECRET_KEY ="key_secret_key"
    private const val KEY_FIRST_RESULT = "key_first_result"
    private const val KEY_RATE_BACK = "key_rate_back"
    private const val KEY_IS_ID_INITIATED = "key_is_id_initiated"
    private const val KEY_USER_ID = "key_user_id"

    private const val KEY_LAST_FETCH_TEMPLATE_TIME = "key_last_fetch_template_time"
    var secretKey : String
        get() = MyPreferences.valueOf(
            KEY_SECRET_KEY,
            "abc-evVJh3QfTwqfSWfUSELOLN:APA91bFO5u1yM1p3vAHdEJXVQfU3YySmhL93Suu3HaR4hVDGIYCVZMmM7qskukc_fU_8S96kqKUHrA8U42rlwS40TjYvkov8cJCwyG--lrAn2Lmk0BTyn-k"
        )
        set(value) = MyPreferences.setValue(KEY_SECRET_KEY, value)

    var firstResult : Boolean
        get() = MyPreferences.valueOf(KEY_FIRST_RESULT, true)
        set(value) {
            MyPreferences.setValue(KEY_FIRST_RESULT, value)
        }

    var lastFetchTemplateTime : Long
        get() = MyPreferences.valueOf(KEY_LAST_FETCH_TEMPLATE_TIME, 0L)
        set(value) {
            MyPreferences.setValue(KEY_LAST_FETCH_TEMPLATE_TIME, value)
        }

    var rateBack : Boolean
        get() = MyPreferences.valueOf(KEY_RATE_BACK, true)
        set(value) {
            MyPreferences.setValue(KEY_RATE_BACK, value)
        }

    var userId : String
        get() = MyPreferences.valueOf(KEY_USER_ID, "DefaultID")
        set(value) {
            MyPreferences.setValue(KEY_USER_ID, value)
        }

    var isIdInitiated : Boolean
        get() = MyPreferences.valueOf(KEY_IS_ID_INITIATED, false)
        set(value) {
            MyPreferences.setValue(KEY_IS_ID_INITIATED, value)
        }


    object MyPreferences {
        private const val NAME = "math_preferences"
        private const val MODE = Context.MODE_PRIVATE
        private lateinit var preferences: SharedPreferences
        private var initialized = false

        fun init(context: Context) {
            preferences = context.getSharedPreferences(NAME, MODE)
            initialized = true
        }
        fun get() = preferences

        fun getAll(): MutableMap<String,*> = preferences.all
        private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
            val editor = edit()
            operation(editor)
            editor.apply()
        }

        @Suppress("UNCHECKED_CAST")
        fun <T> valueOf(key: String, defaultValue: T): T {
            return when (defaultValue) {
                is Boolean -> preferences.getBoolean(key, defaultValue)
                is Int -> preferences.getInt(key, defaultValue)
                is Float -> preferences.getFloat(key, defaultValue)
                is Long -> preferences.getLong(key, defaultValue)
                is String -> preferences.getString(key, defaultValue)
                else -> throw IllegalArgumentException("Generic type is not supported")
            } as T
        }

        fun <T> setValue(key: String, value: T) {
            when (value) {
                is Boolean -> preferences.edit { it.putBoolean(key, value) }
                is Int -> preferences.edit { it.putInt(key, value) }
                is Float -> preferences.edit { it.putFloat(key, value) }
                is Long -> preferences.edit { it.putLong(key, value) }
                is String -> preferences.edit { it.putString(key, value) }
                else -> throw IllegalArgumentException("$value type is not supported")
            }
        }

    }
}
fun SharedPreferences.registerSharedPreferenceChangeListener(
    owner: LifecycleOwner, listener: (SharedPreferences, String?) -> Unit
) {
    owner.lifecycle.addObserver(SharedPreferenceChangeListener(this, listener))
}
