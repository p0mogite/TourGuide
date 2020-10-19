package com.example.tourguide

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CategoryAdapter (val context: Context, val fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int) : Fragment {
        when (position) {
            0 -> return BanksFragment()
            1 -> return MuseumsFragment()
            2 -> return RestaurantsFragment()
            3 -> return SquaresFragment()
        }
        return Fragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return context.getString(R.string.banks)
            1 -> return context.getString(R.string.museums)
            2 -> return context.getString(R.string.restaurants)
            3 -> return context.getString(R.string.squares)
        }
        return null
    }
}