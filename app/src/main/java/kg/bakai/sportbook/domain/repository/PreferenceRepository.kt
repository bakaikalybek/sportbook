package kg.bakai.sportbook.domain.repository

interface PreferenceRepository {
    fun isUserLoggedIn(): Boolean
    fun setUserLogin(status: Boolean)
    fun setFirstTimeLaunch(isFirstTime: Boolean)
    fun isFirstTimeLaunch(): Boolean
}