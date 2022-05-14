package com.omdb.app.data

import com.omdb.app.BuildConfig
import com.omdb.app.contract.Repository
import com.omdb.app.data.api.MovieService
import com.omdb.app.data.mapper.MovieMapper
import com.omdb.app.data.model.Movie
import com.omdb.app.di.IoDispatcher
import com.omdb.app.ui.adapter.MovieModel
import com.omdb.app.utils.ViewState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * @Details BlogRepository
 * @Author Roshan Bhagat
 * @property movieMapper
 * @property ioDispatcher
 * @constructor Create [MovieRepository]
 */
@ViewModelScoped
class MovieRepository @Inject constructor(
    override val apiService: MovieService,
    private val movieMapper: MovieMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : Repository {

    /**
     * @return [ViewState]
     */
    override suspend fun getSearchResultData(
        searchTitle: String,
        pageIndex: Int
    ): Flow<List<MovieModel>> {
        return flow {
            val searchResults = apiService.getSearchResultData(
                searchTitle, BuildConfig.API_KEY, pageIndex
            )
            emit(movieMapper.mapFromEntityList(searchResults))
        }.flowOn(ioDispatcher)
    }


    override suspend fun getMovieDetailsData(imdbId: String): Flow<Movie> {
        return flow {
            val movie = apiService.getMovieDetailsData(
                imdbId, BuildConfig.API_KEY
            )
            emit(movie)
        }.flowOn(ioDispatcher)
    }
}