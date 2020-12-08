package ru.selfmadeperson.flagscountries.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.selfmadeperson.flagscountries.mvp.model.entity.RestCountry

interface ICountriesCache {
    fun getCountries(): Single<List<RestCountry>>
    fun putCountries(countries: List<RestCountry>): Completable
}