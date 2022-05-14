package com.omdb.app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.omdb.app.core.BaseViewModel
import com.omdb.app.data.model.SearchModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Details SearchViewModel:
 * @Author Roshan Bhagat
 */
@HiltViewModel
class SearchViewModel @Inject constructor(model: SearchModel) : BaseViewModel() {
    private val _searchLiveData: MutableLiveData<SearchModel> by lazy {
        MutableLiveData<SearchModel>()
    }

    val searchLiveData: MutableLiveData<SearchModel> = _searchLiveData


    /**
     *
     */
    init {
        searchLiveData.postValue(model)
    }
}