package io.github.aungkothet.padc.assignment7.network.dataAgents

import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import io.github.aungkothet.padc.assignment7.network.MovieApi
import io.github.aungkothet.padc.assignment7.network.response.MovieResponse
import io.github.aungkothet.padc.assignment7.utils.BASE_URL
import io.github.aungkothet.padc.assignment7.utils.EM_NULL_RESPONSE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

object RetrofitAgent : MovieDataAgent {

    private val movieApi: MovieApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, SECONDS)
            .writeTimeout(15, SECONDS)
            .readTimeout(15, SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }

    override fun getMovieList(
        accessToken: String,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = movieApi.getMovieList(accessToken)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                val eventsResponse = response.body()
                if (eventsResponse != null) {
                    if (eventsResponse.isResponseOk())
                        onSuccess(eventsResponse.data)
                    else
                        onFailure(response.message())
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
        })
    }
}