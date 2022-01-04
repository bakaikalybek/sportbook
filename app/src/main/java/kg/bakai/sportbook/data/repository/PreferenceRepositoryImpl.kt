package kg.bakai.sportbook.data.repository

import kg.bakai.sportbook.data.data_source.SharedPreferencesManager
import kg.bakai.sportbook.domain.repository.PreferenceRepository

class PreferenceRepositoryImpl(
    private val prefs: SharedPreferencesManager
): PreferenceRepository {

    override fun setUserLogin(status: Boolean) {
        prefs.setUserLogin(status)
    }

    override fun isUserLoggedIn(): Boolean {
        return prefs.isUserLoggedIn()
    }

    override fun setFirstTimeLaunch(isFirstTime: Boolean) {
        prefs.setFirstTimeLaunch(isFirstTime)
    }

    override fun isFirstTimeLaunch(): Boolean {
        return prefs.isFirstTimeLaunch()
    }
}