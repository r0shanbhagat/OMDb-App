package com.omdb.app.contract

import com.omdb.app.utils.DataState
import kotlinx.coroutines.flow.Flow


/**
 * @Details :IRepository
 * @Author Roshan Bhagat
 *
 * @param
 * @constructor Create Repository
 */
interface Repository {

    val dataSource: MovieDataSource

    /**
     * Get MovieList
     *
     * @return
     */
    suspend fun getMovieList(): Flow<DataState>

}