package io.github.aungkothet.padc.assignment7.network.response

import com.google.gson.annotations.SerializedName
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import io.github.aungkothet.padc.assignment7.utils.CODE_RESPONSE_OK

data class MovieResponse(
    @SerializedName("code")
    val code:Int,
    @SerializedName("message")
    val message:String,
    @SerializedName("data")
    val data:List<MovieVo>){

    fun isResponseOk(): Boolean {
        return code ===CODE_RESPONSE_OK && data != null
    }
}