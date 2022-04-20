package com.omdb.app.ui.view

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.omdb.app.R
import com.omdb.app.core.BaseActivity
import com.omdb.app.core.BaseViewModel
import com.omdb.app.databinding.ActivityMovieBinding
import dagger.hilt.android.AndroidEntryPoint


/**
/**
 * @Details TruecallerBlogActivity : Main activity where user0interface will
 * be displayed and user can interact with app on launch
 * @Author Roshan Bhagat
*/ *
 * @constructor Create Truecaller movie activity
 */
@AndroidEntryPoint
class MovieActivity(
    override val layoutResId: Int = R.layout.activity_movie
) :
    BaseActivity<ActivityMovieBinding, BaseViewModel>() {

    private lateinit var navController: NavController


    override fun createViewModel(): BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController(R.id.nav_host_fragment)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}