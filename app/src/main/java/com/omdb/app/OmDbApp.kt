package com.omdb.app

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * @Details OmDbApp is the Application class to manage the entire App scope
 * @Author Roshan Bhagat
 */
@HiltAndroidApp
class OmDbApp : MultiDexApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}