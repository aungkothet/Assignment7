package io.github.aungkothet.padc.assignment7

import android.app.Application
import io.github.aungkothet.padc.assignment7.data.models.MovieModelImpl

class MovieApp :Application(){

    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initializeDatabase(this)
    }
}