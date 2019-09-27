package io.github.aungkothet.padc.assignment7.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.aungkothet.padc.assignment7.R
import io.github.aungkothet.padc.assignment7.adapters.MoviesRecyclerAdapter
import io.github.aungkothet.padc.assignment7.data.models.MovieModelImpl
import io.github.aungkothet.padc.assignment7.delegates.MovieDelegate
import io.github.aungkothet.padc.assignment7.utils.ACCESS_TOKEN
import kotlinx.android.synthetic.main.fragment_now_showing.view.*

/**
 * A simple [Fragment] subclass.
 */
class NowShowingFragment : Fragment() {

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
        val moviesRecyclerAdapter = MoviesRecyclerAdapter(delegate)
        MovieModelImpl.getMovies(ACCESS_TOKEN, onSuccess = {
            moviesRecyclerAdapter.setNewData(it.toMutableList())
        }) {
            delegate.showNnackBar(it)
        }
        view.movieRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = moviesRecyclerAdapter
        }
        return view
    }


}
