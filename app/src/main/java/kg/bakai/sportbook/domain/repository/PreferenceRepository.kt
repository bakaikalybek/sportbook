package kg.bakai.sportbook.domain.repository

import kg.bakai.sportbook.domain.model.LoginItem
import kg.bakai.sportbook.domain.model.OnboardingItem
import kg.bakai.sportbook.domain.model.User

interface PreferenceRepository {
    fun getLoginSlides(): List<LoginItem>
    fun getOnboardingItems(): List<OnboardingItem>
    fun isUserLoggedIn(): Boolean
    fun setUserLogin(status: Boolean)
    fun setFirstTimeLaunch(isFirstTime: Boolean)
    fun isFirstTimeLaunch(): Boolean

    fun saveUserData(name: String, age: Int, height: Int, weight: Int, goalWeight: Int)
    fun fetchUserData(): User
}