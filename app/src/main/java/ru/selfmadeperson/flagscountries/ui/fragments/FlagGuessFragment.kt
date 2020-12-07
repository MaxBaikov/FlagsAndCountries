package ru.selfmadeperson.flagscountries.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.selfmadeperson.flagscountries.R
import ru.selfmadeperson.flagscountries.mvp.presenter.FlagGuessPresenter
import ru.selfmadeperson.flagscountries.mvp.view.FlagGuessView
import ru.selfmadeperson.flagscountries.ui.App
import ru.selfmadeperson.flagscountries.ui.BackButtonListener
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class FlagGuessFragment: MvpAppCompatFragment(), FlagGuessView, BackButtonListener{

    @Inject lateinit var router: Router
    @Inject lateinit var scheduler: Scheduler

    companion object {
        fun newInstance() = FlagGuessFragment()
    }

    val presenter: FlagGuessPresenter by moxyPresenter {
        FlagGuessPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )=View.inflate(context, R.layout.fragment_flagguess,null)

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun backPressed() = presenter.backPressed()
}


