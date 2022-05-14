package com.omdb.app.contract

import com.omdb.app.data.api.MovieService
import com.omdb.app.data.model.Movie
import com.omdb.app.ui.adapter.MovieModel
import kotlinx.coroutines.flow.Flow


/**
 * @Details :IRepository
 * @Author Roshan Bhagat
 *
 * @param
 * @constructor Create Repository
 */
interface Repository {

    val apiService: MovieService

    /**
     * Get search result data.
     *
     * @param searchTitle Search title
     * @param pageIndex Page index
     * @return
     */
    suspend fun getSearchResultData(searchTitle: String, pageIndex: Int): Flow<List<MovieModel>>

    /**
     * Get movie details data.
     *
     * @param imdbId Imdb id
     * @return [Flow]
     */
    suspend fun getMovieDetailsData(imdbId: String): Flow<Movie>
}