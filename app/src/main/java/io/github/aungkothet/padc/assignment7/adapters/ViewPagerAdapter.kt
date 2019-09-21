package io.github.aungkothet.padc.assignment7.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.gson.Gson
import io.github.aungkothet.padc.assignment7.data.vos.MovieVo
import io.github.aungkothet.padc.assignment7.fragments.MovieFragment

class ViewPagerAdapter(supportFragmentManager: FragmentManager, val movieList: List<MovieVo>) :
    FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        val gsonString =Gson().toJson(movieList[position],MovieVo::class.java)
        return MovieFragment.newInstance(gsonString)
    }

    override fun getCount(): Int {
        return movieList.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }
}