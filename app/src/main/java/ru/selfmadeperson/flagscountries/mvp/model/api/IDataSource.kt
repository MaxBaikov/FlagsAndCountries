package ru.selfmadeperson.flagscountries.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.selfmadeperson.flagscountries.mvp.model.entity.RestCountry

interface IDataSource {
    @GET("/all")
    fun getCountries(): Single<List<RestCountry>>
}