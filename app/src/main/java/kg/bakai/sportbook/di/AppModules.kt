package kg.bakai.sportbook.di

import android.app.Application
import android.content.SharedPreferences
import androidx.room.Room
import kg.bakai.sportbook.data.data_source.DataStoreManager
import kg.bakai.sportbook.data.data_source.SharedPreferencesManager
import kg.bakai.sportbook.data.data_source.RecordsDao
import kg.bakai.sportbook.data.data_source.RecordsDatabase
import kg.bakai.sportbook.data.repository.DataStoreRepositoryImpl
import kg.bakai.sportbook.data.repository.PreferenceRepositoryImpl
import kg.bakai.sportbook.data.repository.RecordsRepositoryImpl
import kg.bakai.sportbook.domain.repository.DataStoreRepository
import kg.bakai.sportbook.domain.repository.PreferenceRepository
import kg.bakai.sportbook.domain.repository.RecordsRepository
import kg.bakai.sportbook.presentation.login.LoginViewModel
import kg.bakai.sportbook.presentation.main.MainViewModel
import kg.bakai.sportbook.presentation.records.RecordsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): RecordsDatabase {
        return Room.databaseBuilder(application, RecordsDatabase::class.java, "records_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideRecordsDao(database: RecordsDatabase): RecordsDao {
        return database.recordsDao
    }

    single { provideDatabase(get()) }
    single { provideRecordsDao(get()) }
}

val repositoryModule = module {
    single<RecordsRepository> { RecordsRepositoryImpl(get()) }
    single<PreferenceRepository> { PreferenceRepositoryImpl(get()) }
    single<DataStoreRepository> { DataStoreRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { RecordsViewModel(get()) }
    viewModel { LoginViewModel(get(), get()) }
}

val appModule = module {
    fun getSharedPreference(androidApplication: Application): SharedPreferences {
        return androidApplication.getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
    }
    single { getSharedPreference(androidApplication()) }
    single { SharedPreferencesManager(get()) }
    single { DataStoreManager(get()) }
}