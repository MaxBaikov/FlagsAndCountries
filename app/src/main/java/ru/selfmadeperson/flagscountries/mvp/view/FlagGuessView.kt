package ru.selfmadeperson.flagscountries.mvp.view

import android.graphics.Bitmap
import android.media.Image
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface FlagGuessView : MvpView {
    fun setTextButton1(text: String)
    fun setTextButton2(text: String)
    fun setTextButton3(text: String)
    fun setFlagImage(flag: Bitmap)
    fun init()
}