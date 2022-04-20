package com.omdb.app.ui.adapter

import androidx.databinding.BaseObservable
import com.omdb.app.R
import com.omdb.app.ui.viewmodel.MovieViewModel

data class MovieModel(
    var title: String,
    var body: String,
    var image: String,
    var category: String
) : BaseObservable(), ItemViewModel {

    override val layoutId: Int = R.layout.item_movie_list

    override val viewType: Int = MovieViewModel.LISTING_ITEM
}