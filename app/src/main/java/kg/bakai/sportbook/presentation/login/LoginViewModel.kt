package kg.bakai.sportbook.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.bakai.sportbook.R
import kg.bakai.sportbook.domain.model.FieldType
import kg.bakai.sportbook.domain.model.LoginItem
import kg.bakai.sportbook.domain.model.OnboardingItem
import kg.bakai.sportbook.domain.repository.PreferenceRepository

class LoginViewModel(
    private val preferenceRepository: PreferenceRepository
): ViewModel() {
    private val _isFirstLaunch = MutableLiveData<Boolean>()
    val isFirstLaunch: LiveData<Boolean> = _isFirstLaunch

    private val _slidesLogin = MutableLiveData<List<LoginItem>>()
    val slidesLogin: LiveData<List<LoginItem>> = _slidesLogin

    private val _slidesOnboarding = MutableLiveData<List<OnboardingItem>>()
    val slidesOnboarding: LiveData<List<OnboardingItem>> = _slidesOnboarding

    init {
        _isFirstLaunch.postValue(preferenceRepository.isFirstTimeLaunch())

        _slidesLogin.postValue(preferenceRepository.getLoginSlides())
        _slidesOnboarding.postValue(preferenceRepository.getOnboardingItems())
    }

    fun isUserLoggedIn(): Boolean {
        return preferenceRepository.isUserLoggedIn()
    }

    fun saveProfileData() {
        preferenceRepository.setUserLogin(true)
    }

    fun finishOnboarding() {
        preferenceRepository.setFirstTimeLaunch(false)
    }
}