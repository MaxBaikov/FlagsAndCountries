package ru.selfmadeperson.flagscountries.ui.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.selfmadeperson.flagscountries.R
import ru.selfmadeperson.flagscountries.mvp.presenter.MainPresenter
import ru.selfmadeperson.flagscountries.mvp.view.MainView
import ru.selfmadeperson.flagscountries.ui.App
import ru.selfmadeperson.flagscountries.ui.BackButtonListener
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject lateinit var navigatorHolder: NavigatorHolder

    private val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNav()
        App.instance.appComponent.inject(this)
    }

    private fun initBottomNav() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_flags -> {presenter.flagsSelected(); true}
                R.id.navigation_cities -> {presenter.citiesSelected(); true}
                R.id.navigation_countries -> {presenter.countriesSelected(); true}
                else -> false
            }
        }
    }

    val presenter: MainPresenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }

}

