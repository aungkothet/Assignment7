package io.github.aungkothet.padc.assignment7.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.aungkothet.padc.assignment7.R
import io.github.aungkothet.padc.assignment7.adapters.ViewPagerAdapter
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import io.github.aungkothet.padc.assignment7.delegates.MovieDelegate
import io.github.aungkothet.padc.assignment7.network.dataAgents.RetrofitAgent
import io.github.aungkothet.padc.assignment7.utils.ACCESS_TOKEN
import kotlinx.android.synthetic.main.fragment_now_showing.view.*

/**
 * A simple [Fragment] subclass.
 */
class NowShowingFragment : Fragment() {

    var movieList: List<MovieVo> = arrayListOf()

    private lateinit var delegate: MovieDelegate
    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate = context as MovieDelegate
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_now_showing, container, false)
        RetrofitAgent.getMovieList(ACCESS_TOKEN,onSuccess = {
            movieList = it
            val viewPagerAdapter = ViewPagerAdapter(activity?.supportFragmentManager!!,movieList)
            view.vp_now_showing.adapter = viewPagerAdapter
        }){
            delegate.showNnackBar(it)
        }
        return view
    }


}
