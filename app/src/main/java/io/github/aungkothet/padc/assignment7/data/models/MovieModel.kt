package io.github.aungkothet.padc.assignment7.data.models

import io.github.aungkothet.padc.assignment7.data.vos.MovieVo

interface MovieModel {

    fun getMovies(
        accessToken: String,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getMovieById(movieId: Int): MovieVo
}