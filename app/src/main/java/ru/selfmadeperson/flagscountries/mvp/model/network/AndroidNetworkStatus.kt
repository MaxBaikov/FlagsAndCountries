package ru.selfmadeperson.flagscountries.mvp.model.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.selfmadeperson.flagscountries.ui.App

class AndroidNetworkStatus : INetworkStatus {
    private val statusObject = BehaviorSubject.create<Boolean>()
    override val isOnline: Observable<Boolean> get() = statusObject
    override val isOnlineSingle: Single<Boolean> get() = statusObject.first(false)

    init {
        statusObject.onNext(false)

        val connectivityManager = App.instance
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkRequest = NetworkRequest.Builder().build()

        connectivityManager.registerNetworkCallback(networkRequest, object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                statusObject.onNext(true)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                statusObject.onNext(false)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                statusObject.onNext(false)
            }
        })
    }
}
