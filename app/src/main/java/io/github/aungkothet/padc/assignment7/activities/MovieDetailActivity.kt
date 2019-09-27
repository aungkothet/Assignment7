package io.github.aungkothet.padc.assignment7.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import io.github.aungkothet.padc.assignment7.R
import io.github.aungkothet.padc.assignment7.adapters.CastAndCrewRecyclerAdapter
import io.github.aungkothet.padc.assignment7.data.vos.CastVo
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity() {

    private val casts = arrayListOf(
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
    companion object {
        private const val IE_MOVIE = "intentMovie"
        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(IE_MOVIE, id)
            return intent
        }
    }

    private fun ImageView.setImage(url:String){
        Glide.with(this).load(url).error(R.drawable.default_banner)
            .into(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        img_close.setOnClickListener { finish() }
        val movieId = intent.getIntExtra(IE_MOVIE, 1)
        val movieVo: MovieVo = dataAgent.getMovieById(movieId)
        img_movie_banner_detail.setImage(movieVo.poster)
        tvMovieName.text = movieVo.movieName
        tvMovieGenre.text = movieVo.genreString()
        tvImdbDetail.text = "${movieVo.imdb}"
        tv_rt_percent_detail.text = "${movieVo.rottenTomato}%"
        tv_metacritic_detail.text = "${movieVo.metaCentric}%"
        tv_movie_desc_detail.text = movieVo.overview

        val castAndCrewRecyclerAdapter = CastAndCrewRecyclerAdapter().apply {
            setNewData(casts)
        }
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        cast_recycler_view.apply {
            layoutManager = linearLayoutManager
            adapter = castAndCrewRecyclerAdapter
        }
    }
}
