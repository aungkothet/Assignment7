package io.github.aungkothet.padc.assignment7.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class MovieVo(

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id: Int,

    @SerializedName("movie_name")
    @ColumnInfo(name = "movie_name")
    val movieName: String,

    @SerializedName("imdb")
    @ColumnInfo(name = "imdb")
    val imdb: Double,

    @SerializedName("rotten_tomato")
    @ColumnInfo(name = "rotten_tomato")
    val rottenTomato: Int,

    @SerializedName("meta_centric")
    @ColumnInfo(name = "meta_centric")
    val metaCentric: Int,

    @SerializedName("genre")
    @ColumnInfo(name = "genre")
    val genre: List<GenreVo>,

    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    val overview: String,

    @SerializedName("poster")
    @ColumnInfo(name = "poster")
    val poster: String
) {
    fun genreString(): String {
        var result = ""
        genre.forEach {
            result += "${it.name} / "
        }
        return result.removeSuffix("/ ")
    }
}
