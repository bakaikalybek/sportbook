package kg.bakai.sportbook.domain.repository

import kg.bakai.sportbook.domain.model.LoginItem
import kg.bakai.sportbook.domain.model.OnboardingItem

interface PreferenceRepository {
    fun getLoginSlides(): List<LoginItem>
    fun getOnboardingItems(): List<OnboardingItem>
    fun isUserLoggedIn(): Boolean
    fun setUserLogin(status: Boolean)
    fun setFirstTimeLaunch(isFirstTime: Boolean)
    fun isFirstTimeLaunch(): Boolean
}