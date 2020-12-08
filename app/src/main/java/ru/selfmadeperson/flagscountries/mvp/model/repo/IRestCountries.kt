package ru.selfmadeperson.flagscountries.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.selfmadeperson.flagscountries.mvp.model.entity.RestCountry

interface IRestCountries {
    fun getCountries(): Single<List<RestCountry>>
}