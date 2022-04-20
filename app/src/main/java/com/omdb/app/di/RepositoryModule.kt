package com.omdb.app.di

import com.omdb.app.contract.MovieDataSource
import com.omdb.app.contract.Repository
import com.omdb.app.data.MovieRemoteDataSource
import com.omdb.app.data.MovieRepository
import com.omdb.app.data.api.MovieService
import com.omdb.app.data.mapper.MovieMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Qualifier

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
     * @param movieDataSource
     * @param ioDispatcher
     * @return
     */
    @Provides
    fun provideMovieRepository(
        @RemoteDataSource movieDataSource: MovieDataSource,
        movieMapper: MovieMapper,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): Repository = MovieRepository(movieDataSource, movieMapper, ioDispatcher)

    /**
     * Provide movie remote data source
     *
     * @param apiService
     * @param ioDispatcher
     * @return
     */
    @RemoteDataSource
    @Provides
    fun provideMovieRemoteDataSource(
        apiService: MovieService,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): MovieDataSource =
        MovieRemoteDataSource(apiService, ioDispatcher)

}


@Retention(AnnotationRetention.SOURCE)
@Qualifier
annotation class RemoteDataSource