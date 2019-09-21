package io.github.aungkothet.padc.assignment7.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import io.github.aungkothet.padc.assignment7.fragments.NowShowingFragment

class TabPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(p0: Int): Fragment {
        return NowShowingFragment()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Now Showing"
            1 -> "Cinema"
            else -> "Coming Soon"
        }
    }
}