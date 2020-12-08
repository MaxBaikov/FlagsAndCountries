package ru.selfmadeperson.flagscountries.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}