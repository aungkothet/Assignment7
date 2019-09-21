package io.github.aungkothet.padc.assignment7.data.models

import android.content.Context
import io.github.aungkothet.padc.assignment7.network.dataAgents.MovieDataAgent
import io.github.aungkothet.padc.assignment7.network.dataAgents.RetrofitAgent

abstract class BaseModel(private val context:Context) {
    var dataAgent:MovieDataAgent = RetrofitAgent
}