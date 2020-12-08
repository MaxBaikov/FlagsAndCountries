package ru.selfmadeperson.flagscountries.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.selfmadeperson.flagscountries.R
import ru.selfmadeperson.flagscountries.mvp.presenter.CountriesPresenter
import ru.selfmadeperson.flagscountries.mvp.presenter.CountryDescriptionPresenter
import ru.selfmadeperson.flagscountries.mvp.view.CountriesView
import ru.selfmadeperson.flagscountries.mvp.view.CountryDescriptionView
import ru.selfmadeperson.flagscountries.ui.App
import ru.selfmadeperson.flagscountries.ui.BackButtonListener

class CountriesFragment: MvpAppCompatFragment(), CountriesView, BackButtonListener {

    companion object {
        fun newInstance() = CountriesFragment()
    }

    val presenter: CountriesPresenter by moxyPresenter {
        CountriesPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )= View.inflate(context, R.layout.fragment_countries,null)


    override fun backPressed() = presenter.backPressed()

}