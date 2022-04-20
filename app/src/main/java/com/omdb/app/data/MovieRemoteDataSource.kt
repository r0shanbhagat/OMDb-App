package com.omdb.app.data

import com.omdb.app.contract.MovieDataSource
import com.omdb.app.data.api.MovieService
import com.omdb.app.data.model.MovieResponse
import com.omdb.app.di.IoDispatcher
import com.omdb.app.utils.DataState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * @Details :MovieRemoteDataSource
 * @Author Roshan Bhagat
 *
 * @property apiService
 * @property ioDispatcher
 * @constructor Create Movie parse remote data source
 */
@ViewModelScoped
class MovieRemoteDataSource @Inject constructor(
    override val apiService: MovieService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MovieDataSource {

    /**
     * @return [DataState]
     */
    override suspend fun getMovieList(): Flow<List<MovieResponse>> = flow {
        val movie = apiService.getMoviesList()
        emit(movie)
    }.flowOn(ioDispatcher)

}
