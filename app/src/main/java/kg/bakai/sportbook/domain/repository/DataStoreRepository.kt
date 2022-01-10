package kg.bakai.sportbook.domain.repository

import kg.bakai.sportbook.domain.model.User
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun fetchUser(): User
    fun fetchUserFlow(): Flow<User>
    suspend fun saveUser(name: String, age: Int, height: Int, weight: Int)
}