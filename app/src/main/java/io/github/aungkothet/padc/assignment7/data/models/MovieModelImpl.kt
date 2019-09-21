package io.github.aungkothet.padc.assignment7.data.models

import android.content.Context
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo

class MovieModelImpl (context: Context):BaseModel(context),MovieModel{

    override fun getEvents(accessToken:String, onSuccess: (List<MovieVo>) -> Unit, onFailure: (String) -> Unit) {
        dataAgent.getMovieList(accessToken,onSuccess, onFailure)
    }

}