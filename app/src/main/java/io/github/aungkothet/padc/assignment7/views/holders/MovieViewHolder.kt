package io.github.aungkothet.padc.assignment7.views.holders

import android.view.View
import com.bumptech.glide.Glide
import io.github.aungkothet.padc.assignment7.R
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import io.github.aungkothet.padc.assignment7.delegates.MovieDelegate
import kotlinx.android.synthetic.main.fragment_movie.view.*

class MovieViewHolder(itemView: View, private val delegate: MovieDelegate) :BaseViewHolder<MovieVo>(itemView){

    override fun bindData(data: MovieVo) {
        itemView.img_down.setOnClickListener { delegate.onDetailIconClicked(data.id) }
        itemView.tv_movie_name.text = data.movieName
        itemView.tv_movie_genre.text = data.genreString()
        itemView.tv_imdb.text = "${data.imdb}"
        itemView.tv_rt_percent.text = "${data.rottenTomato}%"
        itemView.tv_metacritic.text = "${data.metaCentric}%"
        Glide.with(itemView).load(data.poster).error(R.drawable.default_banner).into(itemView.img_banner)
    }
}
