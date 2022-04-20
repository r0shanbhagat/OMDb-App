package com.omdb.app.data.api

import com.omdb.app.data.model.MovieResponse
import retrofit2.http.GET


/**
 * @Details ApiService
 * @Author Roshan Bhagat
 * @constructor Create Api service
 */
interface MovieService {
    /**
     * Get movie content
     *
     * @return
     */
    @GET("/movielist.json")
    suspend fun getMoviesList(): List<MovieResponse>

}