package com.omdb.app.di

import com.omdb.app.contract.Repository
import com.omdb.app.data.MovieRepository
import com.omdb.app.data.api.MovieService
import com.omdb.app.data.mapper.MovieMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @Details RepositoryModule
 * @Author Roshan Bhagat
 * @constructor Create Repository module
 */
@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {

    /**
     * Provide movie repository
     *
     * @param apiService
     * @param ioDispatcher
     * @return
     */
    @Provides
    fun provideMovieRepository(
        apiService: MovieService,
        movieMapper: MovieMapper,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): Repository = MovieRepository(apiService, movieMapper, ioDispatcher)

}
