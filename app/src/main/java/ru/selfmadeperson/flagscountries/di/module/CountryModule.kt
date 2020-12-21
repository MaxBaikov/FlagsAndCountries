package ru.selfmadeperson.flagscountries.di.module

import dagger.Module
import dagger.Provides
import ru.selfmadeperson.flagscountries.mvp.model.api.IDataSource
import ru.selfmadeperson.flagscountries.mvp.model.cache.ICountriesCache
import ru.selfmadeperson.flagscountries.mvp.model.cache.room.RoomRestCountriesCache
import ru.selfmadeperson.flagscountries.mvp.model.entity.room.Database
import ru.selfmadeperson.flagscountries.mvp.model.network.INetworkStatus
import ru.selfmadeperson.flagscountries.mvp.model.repo.IRestCountries
import ru.selfmadeperson.flagscountries.mvp.model.repo.RetrofitRestCountries
import javax.inject.Named

@Module
class CountryModule {

    @Provides
    fun countriesCache(database: Database): ICountriesCache {
        return RoomRestCountriesCache(database)
    }

//    @Provides
//    open fun countriesRepo(
//        api: IDataSource,
//        networkStatus: INetworkStatus,
//        cache: ICountriesCache
//    ): IRestCountries {
//        return RetrofitRestCountries(api, networkStatus, cache)
//    }


}

//TODO Здравствуйте, Максим! Посмотрел ваш курсак. error: [Dagger/DuplicateBindings]
//ru.selfmadeperson.flagscountries.mvp.model.repo.IRestCountries is bound multiple times:
//И далее по списку в ошибке указывается где.
//Вы тип IRestCountries возращаете в CountryModule и в RepoModule. Даггер не понимает какой выбрать.
//Либо выберите один модуть который и будет создавать IRestCountries
//или используейте как в ApiModule аннотацию @Named
