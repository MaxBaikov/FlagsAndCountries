package ru.selfmadeperson.flagscountries.mvp.model.entity.room.dao

import androidx.room.*
import ru.selfmadeperson.flagscountries.mvp.model.entity.room.RoomCountry

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(country: RoomCountry)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg countries: RoomCountry)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(countries: List<RoomCountry>)

    @Update
    fun update(country: RoomCountry)

    @Update
    fun update(vararg countries: RoomCountry)

    @Update
    fun update(countries: List<RoomCountry>)

    @Delete
    fun delete(country: RoomCountry)

    @Delete
    fun delete(vararg countries: RoomCountry)

    @Delete
    fun delete(countries: List<RoomCountry>)

    @Query("SELECT * FROM RoomCountry")
    fun getAll(): List<RoomCountry>

    @Query("SELECT * FROM RoomCountry WHERE name = :name LIMIT 1")
    fun findByName(name: String): RoomCountry?
}