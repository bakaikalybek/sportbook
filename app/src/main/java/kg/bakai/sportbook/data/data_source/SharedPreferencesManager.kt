package kg.bakai.sportbook.data.data_source

import android.content.SharedPreferences

class SharedPreferencesManager(
    private val prefs: SharedPreferences
) {
    companion object {
        const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
        const val IS_LOGGED_IN = "IsLoggedIn"
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
        editor.apply()
    }

    fun isFirstTimeLaunch(): Boolean {
        return prefs.getBoolean(IS_FIRST_TIME_LAUNCH, true)
    }

    fun setUserLogin(status: Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(IS_LOGGED_IN, status)
        editor.apply()
    }

    fun isUserLoggedIn(): Boolean {
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }
}