package kg.bakai.sportbook.presentation.main

import androidx.lifecycle.*
import kg.bakai.sportbook.domain.model.Record
import kg.bakai.sportbook.domain.model.User
import kg.bakai.sportbook.domain.repository.DataStoreRepository
import kg.bakai.sportbook.domain.repository.PreferenceRepository
import kg.bakai.sportbook.domain.repository.RecordsRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val recordsRepository: RecordsRepository,
    private val preferenceRepository: PreferenceRepository,
    private val dataStoreRepository: DataStoreRepository
): ViewModel() {
    val user: LiveData<User> = dataStoreRepository.fetchUserFlow().asLiveData()
    private val _userData = MutableLiveData<User>()
    val userData: LiveData<User> = _userData

    init {
        _userData.postValue(preferenceRepository.fetchUserData())
    }
}