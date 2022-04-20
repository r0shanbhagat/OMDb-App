package com.omdb.app.di

import com.omdb.app.contract.Repository
import com.omdb.app.contract.UseCase
import com.omdb.app.domain.MovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Defines all the classes that need to be provided in the scope of the app.
 *@see "https://developer.android.com/training/dependency-injection/hilt-android"
 *
 * Define here all objects that are shared throughout the app, like SharedPreferences, navigators or
 * others. If some of those objects are singletons, they should be annotated with `@Singleton`.
 * @Author Roshan Bhagat
 **/
@InstallIn(ViewModelComponent::class)
@Module
class AppModule {

    /**
     * Provide movie content use case.
     *
     * @param repository Repository
     * @param ioDispatcher Io dispatcher
     * @return [UseCase]
     */
    @Provides
    fun provideBlogContentUseCase(
        repository: Repository,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): UseCase = MovieUseCase(repository, ioDispatcher)
}