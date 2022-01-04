package kg.bakai.sportbook.presentation.login.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.bakai.sportbook.R
import kg.bakai.sportbook.domain.model.OnboardingItem
import kg.bakai.sportbook.domain.repository.PreferenceRepository

class OnboardingViewModel(
    private val preferenceRepository: PreferenceRepository
): ViewModel() {
    private val _slides = MutableLiveData<List<OnboardingItem>>()
    val slides: LiveData<List<OnboardingItem>> = _slides

    init {
        _slides.postValue(
            listOf(
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
        )
    }

    fun finishOnboarding() {
        preferenceRepository.setFirstTimeLaunch(false)
    }
}