package com.themayfields.mike.prestoqcodingchallenge.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.themayfields.mike.prestoqcodingchallenge.R
import com.themayfields.mike.prestoqcodingchallenge.ViewModel.ManagerSpecialsViewModel
import kotlinx.android.synthetic.main.manager_specials_cardview_tab.view.*
import kotlinx.android.synthetic.main.manager_specials_list_tab.view.*
import kotlinx.android.synthetic.main.manager_specials_list_view.view.*

class ManagerSpecialsCardView : Fragment() {
    private lateinit var mViewModel: ManagerSpecialsViewModel

    /**
     * Create the Card View version of the UI using the same ViewModel and data (Model) as the List View version
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.manager_specials_cardview_tab, container, false)
        val fragment = this
        with(rootView.manager_specials_card_view) {
            layoutManager = LinearLayoutManager(this.context)  //This version of the UI is a linear layout containing a list
            adapter = ManagerSpecialsCardViewRecyclerAdapter(fragment)  //Adapter that provides our specials list data
        }

        //Attach to the ViewModel that binds this view to the Specials model
        mViewModel = ManagerSpecialsViewModel.create(this)

        return rootView
    }
}