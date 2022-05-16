package com.omdb.app.data.mapper

import com.omdb.app.contract.EntityMapper
import com.omdb.app.data.model.Search
import com.omdb.app.data.model.SearchResults
import com.omdb.app.ui.adapter.MovieModel
import javax.inject.Inject


/**
 * @Details MovieMapper
 * @Author Roshan Bhagat
 *
 * @constructor
 */
class MovieMapper @Inject constructor() : EntityMapper<Search, MovieModel> {

    override fun mapFromEntity(entity: Search): MovieModel {
        return MovieModel(
            title = entity.title,
            body = entity.type,
            image = entity.poster,
            year = entity.year,
            imdb = entity.imdb
        )
    }

    /**
     * Map from entity list
     *
     * @param entities
     * @return
     */
    fun mapFromEntityList(entities: SearchResults?): List<MovieModel> {
        return entities?.searches?.map {
            mapFromEntity(it)
        } ?: emptyList()
    }

}