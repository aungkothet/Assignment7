package io.github.aungkothet.padc.assignment7.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import io.github.aungkothet.padc.assignment7.R
import io.github.aungkothet.padc.assignment7.adapters.TabPagerAdapter
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import io.github.aungkothet.padc.assignment7.delegates.MovieDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MovieDelegate {
    override fun showNnackBar(message: String) {
        val snackBar = Snackbar.make(window.decorView, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("OK") { snackBar.dismiss() }
        snackBar.show()
    }

    override fun onDetailIconClicked(id: Int) {
        startActivity(
            MovieDetailActivity.newIntent(
                this,
                id
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val adapter = TabPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

}
