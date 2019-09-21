package io.github.aungkothet.padc.assignment7.network.dataAgents

import io.github.aungkothet.padc.assignment7.data.vos.MovieVo

interface MovieDataAgent {
    fun getMovieList(
        accessToken: String,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
}