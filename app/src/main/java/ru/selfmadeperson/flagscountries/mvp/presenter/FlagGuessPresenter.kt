package ru.selfmadeperson.flagscountries.mvp.presenter

import android.widget.ImageView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.selfmadeperson.flagscountries.mvp.model.entity.RestCountry
import ru.selfmadeperson.flagscountries.mvp.model.image.IImageLoader
import ru.selfmadeperson.flagscountries.mvp.model.repo.IRestCountries
import ru.selfmadeperson.flagscountries.mvp.view.FlagGuessView
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import kotlin.random.Random

class FlagGuessPresenter : MvpPresenter<FlagGuessView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var restCountries: IRestCountries

    @Inject
    lateinit var mainThreadScheduler: Scheduler
    @Inject lateinit var imageLoader: IImageLoader<ImageView>

    private val countriesList = mutableListOf<RestCountry>()
    private val countriesListForGuess = mutableListOf<RestCountry>()
    private var rightFlagPosition: Int? = null
    var currentUserChoice: Int? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadDataToView()
    }

    private fun loadDataToView() {
        restCountries.getCountries()
            .observeOn(mainThreadScheduler)
            .subscribe({ countries ->
                countriesList.clear()
                countriesList.addAll(countries)
                setRandomCountries()
                setDataToView()
            }, {
                println("Error: ${it.message}") //TODO убрать в лог
            })
    }

    private fun setDataToView() {
        viewState.setTextButton1(countriesListForGuess[0].name)
        viewState.setTextButton2(countriesListForGuess[1].name)
        viewState.setTextButton3(countriesListForGuess[2].name)
//        viewState.setFlagImage(countriesListForGuess[rightFlagPosition].flagUrl)
//TODO загруить флаг
    }

    private fun setRandomCountries() {
        if (countriesList.size >= 3) {
            countriesListForGuess.clear()
            val numbersAdded = mutableListOf<Int>()
            while (countriesListForGuess.size == 3) {
                val u = Random.nextInt(countriesList.size)
                if (u !in numbersAdded) {
                    countriesListForGuess.add(countriesList[u])
                    numbersAdded.add(u)
                }
            }
            setRandomFlag()

        } else {
            println("Error: loaded less than 3 country") //TODO убрать в лог
        }
    }

    private fun setRandomFlag() {
        rightFlagPosition = Random.nextInt(countriesListForGuess.size)
    }

    fun radioBottomClicked(id: Int) {
        currentUserChoice = id
    }

    fun bottonCheckPressed() {
//TODO проверяем совпадение currentUserChoice с rightFlagPosition+1 и если совпало то поздравляем, если не совпало то на экран с правильным ответом
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}