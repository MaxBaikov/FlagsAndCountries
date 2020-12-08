package ru.selfmadeperson.flagscountries.di.module


import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.selfmadeperson.flagscountries.mvp.model.entity.room.Database
import ru.selfmadeperson.flagscountries.ui.App
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun database(app: App): Database =
        Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
            .build()

}