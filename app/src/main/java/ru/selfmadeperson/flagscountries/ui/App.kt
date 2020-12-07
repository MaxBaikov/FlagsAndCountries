package ru.selfmadeperson.flagscountries.ui

import android.app.Application
import ru.selfmadeperson.flagscountries.di.AppComponent
import ru.selfmadeperson.flagscountries.di.DaggerAppComponent
import ru.selfmadeperson.flagscountries.di.module.AppModule

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}