package kg.bakai.sportbook.data.repository

import kg.bakai.sportbook.R
import kg.bakai.sportbook.data.data_source.SharedPreferencesManager
import kg.bakai.sportbook.domain.model.FieldType
import kg.bakai.sportbook.domain.model.LoginItem
import kg.bakai.sportbook.domain.model.OnboardingItem
import kg.bakai.sportbook.domain.model.User
import kg.bakai.sportbook.domain.repository.PreferenceRepository

class PreferenceRepositoryImpl(
    private val prefs: SharedPreferencesManager
): PreferenceRepository {
    override fun getLoginSlides(): List<LoginItem> {
        return listOf(
            LoginItem(
                name = "Enter your info to personalize app for you",
                type = FieldType.None
            ),
            LoginItem(
                name = "Enter your name",
                type = FieldType.Text
            ),
            LoginItem(
                name = "Enter your age",
                type = FieldType.Number
            ),
            LoginItem(
                name = "Enter your weight",
                type = FieldType.Double
            ),
            LoginItem(
                name = "Enter your height",
                type = FieldType.Double
            )
        )
    }

    override fun getOnboardingItems(): List<OnboardingItem> {
        return listOf(
            OnboardingItem(
                image = R.drawable.img_set_goals,
                title = "Ставь цели",
                description = "Опиши каким ты хочешь стать"
            ),
            OnboardingItem(
                image = R.drawable.img_record,
                title = "Записывай прогресс",
                description = "Записывай тренировки что видеть свой прогресс"
            ),
            OnboardingItem(
                image = R.drawable.img_work,
                title = "Достигай",
                description = "Работай усердно и достигай свои цели"
            )
        )
    }

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

    override fun saveUserData(name: String, age: Int, height: Int, weight: Int, goalWeight: Int) {
        prefs.saveName(name)
        prefs.saveAge(age)
        prefs.saveHeight(height.toFloat())
        prefs.saveWeight(weight.toFloat())
        prefs.saveGoalWeight(goalWeight.toFloat())
    }

    override fun fetchUserData(): User {
        return prefs.fetchUser()
    }
}