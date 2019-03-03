package com.themayfields.mike.prestoqcodingchallenge.Activity

import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import com.themayfields.mike.prestoqcodingchallenge.R
import com.themayfields.mike.prestoqcodingchallenge.View.ManagerSpecialsCardView
import com.themayfields.mike.prestoqcodingchallenge.View.ManagerSpecialsListView

import kotlinx.android.synthetic.main.manager_specials_base_view.*


class ManagerSpecialsActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private lateinit var mSectionsPagerAdapter: SectionsPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.manager_specials_base_view)

       // Create the adapter that will return a fragment for each of the tabbed sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        /**
         * Get the view fragment for a specified tab
         *
         * @return View to show in the specified fragment
         */
        override fun getItem(position: Int): Fragment {
            //Generate the view fragment for each tab position
            return when (position) {
                0 -> ManagerSpecialsCardView()  //First tab: Card view
                1 -> ManagerSpecialsListView()  //Second tab: List view
                else -> ManagerSpecialsCardView()  //Should never happen, but default to card view if unsupported tab found
            }
        }

        /**
         * Get the number of tabs
         */
        override fun getCount(): Int {
            return 2
        }
    }
}
