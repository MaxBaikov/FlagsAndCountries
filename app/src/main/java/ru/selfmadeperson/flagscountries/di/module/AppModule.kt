package ru.selfmadeperson.flagscountries.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import ru.selfmadeperson.flagscountries.ui.App

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App {
        return app
    }

    @Provides
    fun mainTreadScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}