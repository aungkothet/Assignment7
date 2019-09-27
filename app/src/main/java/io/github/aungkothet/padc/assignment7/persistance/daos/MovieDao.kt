package io.github.aungkothet.padc.assignment7.persistance.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo


@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(events: List<MovieVo>): LongArray

    @Query("SELECT * FROM movie")
    abstract fun getAllMovies(): List<MovieVo>

    @Query("SELECT * FROM movie WHERE id=:id")
    abstract fun getMovieById(id: Int): MovieVo
}