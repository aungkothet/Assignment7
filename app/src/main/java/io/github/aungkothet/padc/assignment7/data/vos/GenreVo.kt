package io.github.aungkothet.padc.assignment7.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class GenreVo(
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id: Int,

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String
)