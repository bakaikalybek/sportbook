package kg.bakai.sportbook.data.repository

import kg.bakai.sportbook.data.data_source.DataStoreManager
import kg.bakai.sportbook.domain.model.User
import kg.bakai.sportbook.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class DataStoreRepositoryImpl(
    private val dataStoreManager: DataStoreManager
): DataStoreRepository {
    override suspend fun fetchUser(): User {
        return dataStoreManager.fetchUserData()
    }

    override fun fetchUserFlow(): Flow<User> {
        return dataStoreManager.fetchUserFlow()
    }

    override suspend fun saveUser(name: String, age: Int, height: Int, weight: Int) {
        dataStoreManager.saveName(name)
        dataStoreManager.saveAge(age)
        dataStoreManager.saveHeight(height)
        dataStoreManager.saveWeight(weight)
    }
}