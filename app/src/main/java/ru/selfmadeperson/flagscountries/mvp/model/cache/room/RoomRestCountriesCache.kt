package ru.selfmadeperson.flagscountries.mvp.model.cache.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.selfmadeperson.flagscountries.mvp.model.cache.ICountriesCache
import ru.selfmadeperson.flagscountries.mvp.model.entity.RestCountry
import ru.selfmadeperson.flagscountries.mvp.model.entity.room.RoomCountry
import ru.selfmadeperson.flagscountries.mvp.model.entity.room.Database

class RoomRestCountriesCache(val db: Database) : ICountriesCache {

    override fun getCountries() = Single.fromCallable {
        db.countryDao.getAll().map { country ->
            RestCountry(
                country.name,
                country.capital,
                country.flagUrl,
//                country.topLevelDomain,
//                country.callingCodes,
                country.region,
                country.subRegion,
                country.population,
//                country.timeZones,
            )
        }
    }

    override fun putCountries(countries: List<RestCountry>) =
        Completable.fromAction {
            val roomCountries = countries.map { country ->
                RoomCountry(
                    country.name,
                    country.capital,
                    country.flagUrl,
//                    country.topLevelDomain,
//                    country.callingCodes,
                    country.region,
                    country.subRegion,
                    country.population,
//                    country.timeZones,
                )
            }
            db.countryDao.insert(roomCountries)
        }.subscribeOn(Schedulers.io())
}