package com.omdb.app.contract

import com.omdb.app.data.api.MovieService
import com.omdb.app.data.model.MovieResponse
import kotlinx.coroutines.flow.Flow


/**
 * @Details :MovieService
 * @Author Roshan Bhagat
 * @param
 * @constructor Create Movie data source
 */
interface MovieDataSource {
    val apiService: MovieService

    /**
     * Get MovieList
     *
     * @return
     */
    suspend fun getMovieList(): Flow<List<MovieResponse>>

}