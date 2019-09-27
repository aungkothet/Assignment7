package io.github.aungkothet.padc.assignment7.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import io.github.aungkothet.padc.assignment7.persistance.daos.MovieDao
import io.github.aungkothet.padc.assignment7.persistance.typeconverters.GenreTypeConverter
import io.github.aungkothet.padc.assignment7.utils.DB_NAME

@Database(entities = [MovieVo::class], version = 1, exportSchema = false)
@TypeConverters(GenreTypeConverter::class)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var movieDataBase: MovieDataBase? = null
        fun getInstance(context: Context): MovieDataBase {
            if (movieDataBase == null) {
                movieDataBase = Room.databaseBuilder(context, MovieDataBase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build()
            }
            return movieDataBase!!
        }
    }

}