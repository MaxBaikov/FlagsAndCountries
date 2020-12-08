package ru.selfmadeperson.flagscountries.mvp.model.network

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface INetworkStatus {
    val isOnline: Observable<Boolean>
    val isOnlineSingle: Single<Boolean>
}