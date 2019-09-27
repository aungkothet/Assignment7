package io.github.aungkothet.padc.assignment7.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.github.aungkothet.padc.assignment7.data.vos.GenreVo

class GenreTypeConverter {
    @TypeConverter
    fun toString(list: List<GenreVo>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(json: String): List<GenreVo> {
        return Gson().fromJson<List<GenreVo>>(json, object : TypeToken<List<GenreVo>>() {}.type)
    }
}