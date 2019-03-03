package com.themayfields.mike.prestoqcodingchallenge.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.themayfields.mike.prestoqcodingchallenge.R
import com.themayfields.mike.prestoqcodingchallenge.ViewModel.ManagerSpecialsViewModel
import kotlinx.android.synthetic.main.manager_specials_list_tab.view.*

/**
 * This fragment is a Manager's Special scrolling list view as an example of using the same ViewModel for a different
 * view. This wasn't part of the requirements for the Challenge, but is provided as an example of how using an
 * architecture allows expansion of the requirements in the future.
 */
class ManagerSpecialsListView : Fragment() {
    private lateinit var mViewModel: ManagerSpecialsViewModel

    /**
     * Create the List View version of the UI using the same ViewModel and data (Model) as the Card View version
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.manager_specials_list_tab, container, false)
        val fragment = this
        with(rootView.manager_specials_list_view) {
            layoutManager = LinearLayoutManager(this.context)  //This version of the UI is a linear layout containing a list
            adapter = ManagerSpecialsListViewRecyclerAdapter(fragment)  //Adapter that provides our specials list data
        }

        //Attach to the ViewModel that binds this view to the Specials model
        mViewModel = ManagerSpecialsViewModel.create(this)

        return rootView
    }
}