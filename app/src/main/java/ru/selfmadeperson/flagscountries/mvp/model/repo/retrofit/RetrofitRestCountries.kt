package ru.selfmadeperson.flagscountries.mvp.model.repo

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.selfmadeperson.flagscountries.mvp.model.api.IDataSource
import ru.selfmadeperson.flagscountries.mvp.model.cache.ICountriesCache
import ru.selfmadeperson.flagscountries.mvp.model.network.INetworkStatus

class RetrofitRestCountries(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus,
    private val countriesCache: ICountriesCache

) : IRestCountries {

    override fun getCountries() =
        networkStatus.isOnlineSingle.flatMap { isOnline ->
            if (isOnline) {
                api.getCountries()
                    .flatMap { countries ->
                        countriesCache.putCountries(countries).toSingleDefault(countries)
                    }
            } else {
                countriesCache.getCountries()
            }
        }.subscribeOn(Schedulers.io())
}
