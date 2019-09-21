package io.github.aungkothet.padc.assignment7

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import io.github.aungkothet.padc.assignment7.adapters.CastAndCrewRecyclerAdapter
import io.github.aungkothet.padc.assignment7.data.vos.CastVo
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieVo: MovieVo

    companion object {
        private const val IE_MOVIE = "intentMovie"
        fun newIntent(context: Context, movieString: String?): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(IE_MOVIE, movieString)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        img_close.setOnClickListener { finish() }
        val gsonMovieString = intent.getStringExtra(IE_MOVIE)
        movieVo = Gson().fromJson(gsonMovieString, MovieVo::class.java)
//        img_movie_banner_detail.setImageDrawable(getDrawable(R.drawable.default_banner))
        Glide.with(this).load(movieVo.poster).error(R.drawable.default_banner).into(img_movie_banner_detail)
        tvMovieName.text = movieVo.movieName
        tvMovieGenre.text = "${movieVo.genreString()} 2h"
        tvImdbDetail.text = "${movieVo.imdb}"
        tv_rt_percent_detail.text = "${movieVo.rottenTomato}%"
        tv_metacritic_detail.text = "${movieVo.metaCentric}%"
        tv_movie_desc_detail.text = movieVo.overview

        val casts = arrayListOf(
            CastVo(
                "Dermott Downs"
            ),
            CastVo(
                "Grant Gustin"
            ),
            CastVo(
                "Candice Patton"
            ),
            CastVo(
                "Danielle Panabaker"
            ),
            CastVo(
                "Carlos Valdes"
            ),
            CastVo(
                "Tom Cavanagh"
            ),
            CastVo(
                "Jesse L. Martin"
            ),
            CastVo(
                "Keiynan Lonsdale"
            )
        )
        val adapter = CastAndCrewRecyclerAdapter()
        adapter.setNewData(casts)
//        video_sample_detail.setVideoURI(Uri.parse("https://www.youtube.com/embed/K0nx61nb_jw"))
//        video_sample_detail.start()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        cast_recycler_view.layoutManager = layoutManager
        cast_recycler_view.adapter = adapter


    }
}
