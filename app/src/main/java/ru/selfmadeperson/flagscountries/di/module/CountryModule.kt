package ru.selfmadeperson.flagscountries.di.module

import dagger.Provides
import ru.selfmadeperson.flagscountries.mvp.model.api.IDataSource
import ru.selfmadeperson.flagscountries.mvp.model.cache.ICountriesCache
import ru.selfmadeperson.flagscountries.mvp.model.cache.room.RoomRestCountriesCache
import ru.selfmadeperson.flagscountries.mvp.model.entity.room.Database
import ru.selfmadeperson.flagscountries.mvp.model.network.INetworkStatus
import ru.selfmadeperson.flagscountries.mvp.model.repo.IRestCountries
import ru.selfmadeperson.flagscountries.mvp.model.repo.RetrofitRestCountries

class CountryModule {

    @Provides
    fun countriesCache(database: Database): ICountriesCache {
        return RoomRestCountriesCache(database)
    }


    @Provides
    open fun countriesRepo(api: IDataSource, networkStatus: INetworkStatus, cache: ICountriesCache): IRestCountries {
        return RetrofitRestCountries(api, networkStatus, cache)
    }


}