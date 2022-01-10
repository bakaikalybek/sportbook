package kg.bakai.sportbook.data.data_source

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kg.bakai.sportbook.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreManager(
    private val context: Context
) {
    companion object {
        const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
        const val IS_LOGGED_IN = "IsLoggedIn"

        const val USER_NAME = "UserName"
        const val USER_AGE = "UserAge"
        const val USER_HEIGHT = "UserHeight"
        const val USER_WEIGHT = "UserWeight"

        val nameKey = stringPreferencesKey("USER_NAME")
        val ageKey = intPreferencesKey("USER_AGE")
        val heightKey = floatPreferencesKey("USER_HEIGHT")
        val weightKey = floatPreferencesKey("USER_WEIGHT")
        val goalWeightKey = floatPreferencesKey("USER_GOAL_WEIGHT")
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user data")

    suspend fun saveName(name: String) {
        val dataStoreKey = stringPreferencesKey(USER_NAME)
        context.dataStore.edit { userData ->
            userData[dataStoreKey] = name
        }
    }

    suspend fun saveAge(age: Int) {
        val dataStoreKey = intPreferencesKey(USER_AGE)
        context.dataStore.edit { userData ->
            userData[dataStoreKey] = age
        }
    }

    suspend fun saveHeight(height: Int) {
        val dataStoreKey = floatPreferencesKey(USER_HEIGHT)
        context.dataStore.edit { userData ->
            userData[dataStoreKey] = height.toFloat()
        }
    }

    suspend fun saveWeight(weight: Int) {
        val dataStoreKey = floatPreferencesKey(USER_WEIGHT)
        context.dataStore.edit { userData ->
            userData[dataStoreKey] = weight.toFloat()
        }
    }

    suspend fun fetchUserData(): User {
        val preference = context.dataStore.data.first()
        return User(
            name = preference[nameKey],
            age = preference[ageKey],
            currentHeight = preference[heightKey],
            currentWeight = preference[weightKey],
            goalWeight = preference[goalWeightKey]
        )
    }

   fun fetchUserFlow(): Flow<User> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map {  pref ->
            User(
                name = pref[nameKey],
                age = pref[ageKey],
                currentHeight = pref[heightKey],
                currentWeight = pref[weightKey],
                goalWeight = pref[goalWeightKey]
            )
        }

}