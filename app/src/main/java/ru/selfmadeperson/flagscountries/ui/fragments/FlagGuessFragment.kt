package ru.selfmadeperson.flagscountries.ui.fragments

import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_flagguess.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.selfmadeperson.flagscountries.R
import ru.selfmadeperson.flagscountries.mvp.presenter.FlagGuessPresenter
import ru.selfmadeperson.flagscountries.mvp.view.FlagGuessView
import ru.selfmadeperson.flagscountries.ui.App
import ru.selfmadeperson.flagscountries.ui.BackButtonListener

class FlagGuessFragment: MvpAppCompatFragment(), FlagGuessView, BackButtonListener{

//    @Inject lateinit var router: Router
//    @Inject lateinit var scheduler: Scheduler

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

    override fun backPressed() = presenter.backPressed()

    override fun setTextButton1(text: String) {
        flag_guess_radioButton1.text = text
    }

    override fun setTextButton2(text: String) {
        flag_guess_radioButton2.text = text
    }

    override fun setTextButton3(text: String) {
        flag_guess_radioButton3.text = text
    }

    override fun setFlagImage(flag: Bitmap) {
        flag_imageView.setImageBitmap(flag)
    }

    override fun init() {
        flag_guess_radioButton1.setOnClickListener() {presenter.radioBottomClicked(id)}
        flag_guess_radioButton2.setOnClickListener() {presenter.radioBottomClicked(id)}
        flag_guess_radioButton3.setOnClickListener() {presenter.radioBottomClicked(id)}
        flag_check_button.setOnClickListener() {presenter.bottonCheckPressed()}
    }
}




