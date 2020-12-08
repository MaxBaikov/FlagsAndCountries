package ru.selfmadeperson.flagscountries.di.module

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.selfmadeperson.flagscountries.mvp.model.cache.image.IImageCache
import ru.selfmadeperson.flagscountries.mvp.model.cache.image.room.RoomImageCache
import ru.selfmadeperson.flagscountries.mvp.model.entity.room.Database
import ru.selfmadeperson.flagscountries.mvp.model.image.IImageLoader
import ru.selfmadeperson.flagscountries.mvp.model.network.INetworkStatus
import ru.selfmadeperson.flagscountries.ui.App
import ru.selfmadeperson.flagscountries.ui.image.GlideImageLoader
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
class ImageModule {

    @Named("cacheDir")
    @Singleton
    @Provides
    fun cacheDir(app: App): File = app.cacheDir

    @Singleton
    @Provides
    fun imageCache(database: Database, @Named("cacheDir") cacheDir: File): IImageCache = RoomImageCache(database, cacheDir)

    @Singleton
    @Provides
    fun imageLoader(cache: IImageCache, networkStatus: INetworkStatus)
            : IImageLoader<ImageView> = GlideImageLoader(cache, networkStatus)

}