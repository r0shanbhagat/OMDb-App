package com.omdb.app.ui.callback

/**
 * @Details IItemClick
 * @Author Roshan Bhagat
 */
interface IItemClick<T> {
    fun onItemClick(item: T)
}