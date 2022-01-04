package kg.bakai.sportbook

import android.app.Application
import kg.bakai.sportbook.di.appModule
import kg.bakai.sportbook.di.databaseModule
import kg.bakai.sportbook.di.repositoryModule
import kg.bakai.sportbook.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(databaseModule, repositoryModule, viewModelModule, appModule)
        }
    }
}