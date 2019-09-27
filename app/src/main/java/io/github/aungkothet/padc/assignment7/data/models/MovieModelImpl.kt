package io.github.aungkothet.padc.assignment7.data.models

import io.github.aungkothet.padc.assignment7.data.vos.MovieVo

object MovieModelImpl: BaseModel(),MovieModel{

    override fun getMovies(accessToken:String, onSuccess: (List<MovieVo>) -> Unit, onFailure: (String) -> Unit) {
        val moviesFromDB = dataBase.movieDao().getAllMovies()
        if (moviesFromDB.isNotEmpty()) {
            onSuccess(moviesFromDB)
        } else {
            dataAgent.getMovieList(accessToken, {
                dataBase.movieDao().insertMovies(it)
                onSuccess(it)
            }, onFailure)
        }
    }

    override fun getMovieById(movieId: Int): MovieVo {
        return dataBase.movieDao().getMovieById(movieId)
    }

}