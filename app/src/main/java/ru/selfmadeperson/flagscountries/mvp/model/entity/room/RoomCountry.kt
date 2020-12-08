package ru.selfmadeperson.flagscountries.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomCountry (
    @PrimaryKey
    var name: String,
    var capital: String,
    var flagUrl: String,
//    var topLevelDomain: List<String>,
//    var callingCodes: List<String>,
    var region: String,
    var subRegion: String,
    var population: Int,
//    var timeZones: List<String>,

)