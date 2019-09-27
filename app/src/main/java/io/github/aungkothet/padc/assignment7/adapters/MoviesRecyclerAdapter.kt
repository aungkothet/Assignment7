package io.github.aungkothet.padc.assignment7.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.aungkothet.padc.assignment7.R
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import io.github.aungkothet.padc.assignment7.delegates.MovieDelegate
import io.github.aungkothet.padc.assignment7.views.holders.MovieViewHolder

class MoviesRecyclerAdapter(private val delegate: MovieDelegate) : BaseRecyclerAdapter<MovieViewHolder, MovieVo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_movie, parent, false)
        return MovieViewHolder(view,delegate)
    }

}