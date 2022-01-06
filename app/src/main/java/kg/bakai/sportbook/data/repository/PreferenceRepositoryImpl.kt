package kg.bakai.sportbook.data.repository

import kg.bakai.sportbook.R
import kg.bakai.sportbook.data.data_source.SharedPreferencesManager
import kg.bakai.sportbook.domain.model.FieldType
import kg.bakai.sportbook.domain.model.LoginItem
import kg.bakai.sportbook.domain.model.OnboardingItem
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
                title = "Set Goals",
                description = "Describe what you want to become"
            ),
            OnboardingItem(
                image = R.drawable.img_record,
                title = "Record",
                description = "Record your progress to see how much you have done"
            ),
            OnboardingItem(
                image = R.drawable.img_work,
                title = "Achieve",
                description = "Work hard and achieve your goals"
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
}