package ru.selfmadeperson.flagscountries.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestCountry (

    @Expose val name: String,
    @Expose val capital: String,
    @Expose val flagUrl: String,
//    @Expose val topLevelDomain: List<String>,
//    @Expose val callingCodes: List<String>,
    @Expose val region: String,
    @Expose val subRegion: String,
    @Expose val population: Int,
//    @Expose val timeZones: List<String>,

    ) : Parcelable
