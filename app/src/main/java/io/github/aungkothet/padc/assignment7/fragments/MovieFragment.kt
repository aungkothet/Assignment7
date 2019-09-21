package io.github.aungkothet.padc.assignment7.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.gson.Gson
import io.github.aungkothet.padc.assignment7.R
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import io.github.aungkothet.padc.assignment7.delegates.MovieDelegate
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private lateinit var delegate:MovieDelegate
    private lateinit var movieVo: MovieVo
    companion object {
        private const val ARG_MOVIE = "movieArg"
        fun newInstance(gsonString: String): Fragment {
            val fragment = MovieFragment()
            val args = Bundle()
            args.putString(ARG_MOVIE,gsonString)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate = context as MovieDelegate

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie, container, false)

        val gsonString = arguments?.getString(ARG_MOVIE)
        if(!gsonString.isNullOrBlank()){
            movieVo = Gson().fromJson(gsonString,MovieVo::class.java)
        }
        view.img_down.setOnClickListener { delegate.onDetailIconClicked(gsonString) }
        view.tv_movie_name.text = movieVo.movieName
        view.tv_movie_genre.text = "${movieVo.genreString()} 2h"
        view.tv_imdb.text = "${movieVo.imdb}"
        view.tv_rt_percent.text = "${movieVo.rottenTomato}%"
        view.tv_metacritic.text = "${movieVo.metaCentric}%"
        Glide.with(view).load(movieVo.poster).error(R.drawable.default_banner).into(view.img_banner)
        return view
    }
}
