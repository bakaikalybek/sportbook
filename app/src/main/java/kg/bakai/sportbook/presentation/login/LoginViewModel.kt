package kg.bakai.sportbook.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.bakai.sportbook.domain.repository.PreferenceRepository

class LoginViewModel(
    private val preferenceRepository: PreferenceRepository
): ViewModel() {
    private val _isFirstLaunch = MutableLiveData<Boolean>()
    val isFirstLaunch: LiveData<Boolean> = _isFirstLaunch



    init {
        _isFirstLaunch.postValue(preferenceRepository.isFirstTimeLaunch())
    }

    fun isUserLoggedIn(): Boolean {
        return preferenceRepository.isUserLoggedIn()
    }
}