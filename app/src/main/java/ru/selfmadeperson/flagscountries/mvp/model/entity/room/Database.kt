package ru.selfmadeperson.flagscountries.mvp.model.entity.room

import androidx.room.RoomDatabase
import ru.selfmadeperson.flagscountries.mvp.model.entity.room.dao.CountryDao
import ru.selfmadeperson.flagscountries.mvp.model.entity.room.dao.ImageDao

@androidx.room.Database(entities = [RoomCountry::class, RoomCachedImage::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val countryDao: CountryDao
    abstract val imageDao: ImageDao

    companion object {
        const val DB_NAME = "database.db"
    }
}