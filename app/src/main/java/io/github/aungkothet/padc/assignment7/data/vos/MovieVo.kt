package io.github.aungkothet.padc.assignment7.data.vos

import com.google.gson.annotations.SerializedName

data class MovieVo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("movie_name")
    val movieName: String,
    @SerializedName("imdb")
    val imdb: Double,
    @SerializedName("rotten_tomato")
    val rottenTomato: Int,
    @SerializedName("meta_centric")
    val metaCentric: Int,
    @SerializedName("genre")
    val genre: List<GenreVo>,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster")
    val poster: String
) {
    fun genreString(): String {
        var result = ""
        genre.forEach {
            result += "${it.name} / "
        }
        return result
    }
}
