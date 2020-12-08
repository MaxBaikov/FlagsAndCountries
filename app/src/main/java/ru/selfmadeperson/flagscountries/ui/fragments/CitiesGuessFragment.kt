package ru.selfmadeperson.flagscountries.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.selfmadeperson.flagscountries.R
import ru.selfmadeperson.flagscountries.mvp.presenter.CitiesGuessPresenter
import ru.selfmadeperson.flagscountries.mvp.presenter.CountryDescriptionPresenter
import ru.selfmadeperson.flagscountries.mvp.view.CitiesGuessView
import ru.selfmadeperson.flagscountries.mvp.view.CountryDescriptionView
import ru.selfmadeperson.flagscountries.ui.App
import ru.selfmadeperson.flagscountries.ui.BackButtonListener

class CitiesGuessFragment : MvpAppCompatFragment(), CitiesGuessView, BackButtonListener {

    companion object {
        fun newInstance() = CitiesGuessFragment()
    }

    val presenter: CitiesGuessPresenter by moxyPresenter {
        CitiesGuessPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )= View.inflate(context, R.layout.fragment_citiesguess,null)


    override fun backPressed() = presenter.backPressed()

}