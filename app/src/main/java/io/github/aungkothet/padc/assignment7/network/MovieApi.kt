package io.github.aungkothet.padc.assignment7.network

import io.github.aungkothet.padc.assignment7.network.response.MovieResponse
import io.github.aungkothet.padc.assignment7.utils.GET_ALL_MOVIES
import io.github.aungkothet.padc.assignment7.utils.PARAM_ACCESS_TOKEN
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MovieApi {

    @POST(GET_ALL_MOVIES)
    @FormUrlEncoded
    fun getMovieList(@Field(PARAM_ACCESS_TOKEN) accessToken: String): Call<MovieResponse>
}