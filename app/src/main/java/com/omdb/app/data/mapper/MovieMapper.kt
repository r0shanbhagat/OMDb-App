package com.omdb.app.data.mapper

import com.omdb.app.data.model.MovieResponse
import com.omdb.app.ui.adapter.MovieModel
import com.omdb.app.utils.EntityMapper
import javax.inject.Inject


/**
 * @Details MovieMapper
 * @Author Roshan Bhagat
 *
 * @constructor
 */
class MovieMapper @Inject constructor() : EntityMapper<MovieResponse, MovieModel> {

    override fun mapFromEntity(entity: MovieResponse): MovieModel {
        return MovieModel(
            title = entity.name,
            body = entity.name,
            image = entity.imageUrl,
            category = entity.category
        )
    }

    /**
     * Map from entity list
     *
     * @param entities
     * @return
     */
    fun mapFromEntityList(entities: List<MovieResponse>?): List<MovieModel> {
        return entities?.map {
            mapFromEntity(it)
        } ?: emptyList()
    }

}