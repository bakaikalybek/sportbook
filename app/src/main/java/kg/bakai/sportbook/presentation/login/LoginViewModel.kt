package kg.bakai.sportbook.presentation.login

import androidx.lifecycle.*
import kg.bakai.sportbook.domain.model.OnboardingItem
import kg.bakai.sportbook.domain.repository.DataStoreRepository
import kg.bakai.sportbook.domain.repository.PreferenceRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val preferenceRepository: PreferenceRepository,
    private val dataStoreRepository: DataStoreRepository
): ViewModel() {
    private val _isFirstLaunch = MutableLiveData<Boolean>()
    val isFirstLaunch: LiveData<Boolean> = _isFirstLaunch

    private val _slidesOnboarding = MutableLiveData<List<OnboardingItem>>()
    val slidesOnboarding: LiveData<List<OnboardingItem>> = _slidesOnboarding

    private val _isValid = MediatorLiveData<Boolean>()
    val isValid: LiveData<Boolean> = _isValid
    
    val name = MutableLiveData<String>()
    val age = MutableLiveData<Int>()
    val height = MutableLiveData<Int>()
    val weight = MutableLiveData<Int>()
    val goalWeight = MutableLiveData<Int>()

    init {
        _isFirstLaunch.postValue(preferenceRepository.isFirstTimeLaunch())

        _slidesOnboarding.postValue(preferenceRepository.getOnboardingItems())

        validate()

        _isValid.apply {
            addSource(name) {
                validate()
            }
            addSource(age) {
                validate()
            }
            addSource(height) {
                validate()
            }
            addSource(weight) {
                validate()
            }
            addSource(goalWeight) {
                validate()
            }
        }

    }

    fun isUserLoggedIn(): Boolean {
        return preferenceRepository.isUserLoggedIn()
    }

    fun saveProfileData() {
        preferenceRepository.setUserLogin(true)
        preferenceRepository.saveUserData(name.value!!, age.value!!, height.value!!, weight.value!!, goalWeight.value!!)
        viewModelScope.launch {
            dataStoreRepository.saveUser(name.value!!, age.value!!, height.value!!, weight.value!!)
        }
    }

    fun finishOnboarding() {
        preferenceRepository.setFirstTimeLaunch(false)
    }

    private fun validate() {
        if (!name.value.isNullOrEmpty() && age.value != null && height.value != null && weight.value != null) {
            _isValid.postValue(true)
        } else {
            _isValid.postValue(false)
        }
    }
}