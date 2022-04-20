package com.omdb.app.data

import com.omdb.app.contract.MovieDataSource
import com.omdb.app.contract.Repository
import com.omdb.app.data.mapper.MovieMapper
import com.omdb.app.di.IoDispatcher
import com.omdb.app.di.RemoteDataSource
import com.omdb.app.utils.DataState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject


/**
 * @Details BlogRepository
 * @Author Roshan Bhagat
 * @see "https://developer.android.com/jetpack/guide/data-layer#architecture"
 * @property dataSource
 * @property ioDispatcher
 * @constructor Create [MovieRepository]
 */
@ViewModelScoped
class MovieRepository @Inject constructor(
    @RemoteDataSource override val dataSource: MovieDataSource,
    private val movieMapper: MovieMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : Repository {

    /**
     * Get movie content.
     * @return [DataState]
     */
    override suspend fun getMovieList(): Flow<DataState> = flow {
        dataSource.getMovieList().onStart {
            emit(DataState.Loading)
        }.catch {
            emit(DataState.Error(it))
        }.collect { moviesList ->
            emit(DataState.Success(movieMapper.mapFromEntityList(moviesList)))
        }
    }

}