package kg.bakai.sportbook.data.data_source

import android.content.SharedPreferences
import kg.bakai.sportbook.domain.model.User

class SharedPreferencesManager(
    private val prefs: SharedPreferences
) {
    companion object {
        const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
        const val IS_LOGGED_IN = "IsLoggedIn"

        const val USER_NAME = "UserName"
        const val USER_AGE = "UserAge"
        const val USER_HEIGHT = "UserHeight"
        const val USER_WEIGHT = "UserWeight"
        const val USER_GOAL_WEIGHT = "UserGoalWeight"
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

    fun saveName(name: String) {
        val editor = prefs.edit()
        editor.putString(USER_NAME, name)
        editor.apply()
    }

    fun saveAge(age: Int) {
        val editor = prefs.edit()
        editor.putInt(USER_AGE, age)
        editor.apply()
    }


    fun saveHeight(height: Float) {
        val editor = prefs.edit()
        editor.putFloat(USER_HEIGHT, height)
        editor.apply()
    }

    fun saveWeight(weight: Float) {
        val editor = prefs.edit()
        editor.putFloat(USER_WEIGHT, weight)
        editor.apply()
    }

    fun saveGoalWeight(weight: Float) {
        val editor = prefs.edit()
        editor.putFloat(USER_GOAL_WEIGHT, weight)
        editor.apply()
    }



    fun fetchUser(): User {
        return User(
            name = prefs.getString(USER_NAME, "unknown"),
            age = prefs.getInt(USER_AGE, 0),
            currentHeight = prefs.getFloat(USER_HEIGHT, 0F),
            currentWeight = prefs.getFloat(USER_WEIGHT, 0F),
            goalWeight = prefs.getFloat(USER_GOAL_WEIGHT, 0F)
        )
    }

}