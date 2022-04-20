package com.omdb.app.contract

import com.omdb.app.utils.DataState
import kotlinx.coroutines.flow.Flow

/**
 * I use case
 *
 * @param
 * @constructor Create empty I use case
 */
interface UseCase {

    val repository: Repository

    /**
     * Get movie content
     *
     * @return
     */
    suspend fun getMovieList(): Flow<DataState>


}