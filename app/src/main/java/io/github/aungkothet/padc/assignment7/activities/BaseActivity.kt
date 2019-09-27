package io.github.aungkothet.padc.assignment7.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.aungkothet.padc.assignment7.data.models.MovieModelImpl

abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var dataAgent: MovieModelImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataAgent = MovieModelImpl
    }
}