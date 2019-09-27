package io.github.aungkothet.padc.assignment7.data.models

import android.content.Context
import io.github.aungkothet.padc.assignment7.network.dataAgents.MovieDataAgent
import io.github.aungkothet.padc.assignment7.network.dataAgents.RetrofitAgent
import io.github.aungkothet.padc.assignment7.persistance.MovieDataBase

abstract class BaseModel {
    protected lateinit var dataBase: MovieDataBase
    protected val dataAgent:MovieDataAgent = RetrofitAgent

    fun initializeDatabase(context: Context){
        dataBase = MovieDataBase.getInstance(context)
    }
}