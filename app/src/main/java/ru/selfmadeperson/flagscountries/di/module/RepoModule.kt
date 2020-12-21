package ru.selfmadeperson.flagscountries.di.module

import dagger.Module
import dagger.Provides
import ru.selfmadeperson.flagscountries.mvp.model.api.IDataSource
import ru.selfmadeperson.flagscountries.mvp.model.cache.ICountriesCache
import ru.selfmadeperson.flagscountries.mvp.model.network.INetworkStatus
import ru.selfmadeperson.flagscountries.mvp.model.repo.IRestCountries
import ru.selfmadeperson.flagscountries.mvp.model.repo.RetrofitRestCountries
import javax.inject.Singleton

@Module
class RepoModule {


    @Singleton
    @Provides
    fun countriesRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: ICountriesCache
    ): IRestCountries =
        RetrofitRestCountries(api, networkStatus, cache)

}