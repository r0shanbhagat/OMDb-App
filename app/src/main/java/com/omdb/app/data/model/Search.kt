package com.omdb.app.data.model

import com.google.gson.annotations.SerializedName

/**
 * @Details MovieModel
 * @Author Roshan Bhagat
 */

data class Search(
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("imdbID")
    val imdb: String
)
