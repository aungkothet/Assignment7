package io.github.aungkothet.padc.assignment7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import io.github.aungkothet.padc.assignment7.adapters.TabPagerAdapter
import io.github.aungkothet.padc.assignment7.delegates.MovieDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieDelegate {

    override fun showNnackBar(message: String) {
        val snackBar = Snackbar.make(window.decorView, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("OK") { snackBar.dismiss() }
        snackBar.show()
    }

    override fun onDetailIconClicked(gsonMovieString: String?) {
        startActivity(MovieDetailActivity.newIntent(this,gsonMovieString))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val adapter = TabPagerAdapter(supportFragmentManager)
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

    }


}
