package com.themayfields.mike.prestoqcodingchallenge.View

import android.app.Activity
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel.ManagerSpecialsList
import com.themayfields.mike.prestoqcodingchallenge.Extensions.inflate
import com.themayfields.mike.prestoqcodingchallenge.Repository.ManagerSpecialsRepository
import kotlinx.android.synthetic.main.manager_specials_card_view_item_row.view.*
import android.graphics.Paint
import android.support.constraint.ConstraintLayout
import android.util.DisplayMetrics


/**
 * Manager's Specials adapter RecyclerView Adapter for ListView-style view
 */
class ManagerSpecialsCardViewRecyclerAdapter(val fragment: Fragment):
    RecyclerView.Adapter<ManagerSpecialsCardViewRecyclerAdapter.ManagerSpecialsCardViewHolder>() {

    var mManagerSpecialsList = MutableLiveData<ManagerSpecialsList>()
    var mWidthPixels: Int = 1000

    init {
        //Get display width, in pixels
        val activity: Activity? = fragment.activity
        if (activity != null) {
            val displayMetrics = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
            mWidthPixels = displayMetrics.widthPixels
        }
    }

    override fun getItemCount(): Int {
        return mManagerSpecialsList.value?.managerSpecials?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ManagerSpecialsCardViewRecyclerAdapter.ManagerSpecialsCardViewHolder {
        val inflatedView = parent.inflate(com.themayfields.mike.prestoqcodingchallenge.R.layout.manager_specials_card_view_item_row, false)
        return ManagerSpecialsCardViewHolder(inflatedView)
    }

    override fun onBindViewHolder(viewHolder: ManagerSpecialsCardViewRecyclerAdapter.ManagerSpecialsCardViewHolder, position: Int) {
        viewHolder.bindProduct(mManagerSpecialsList.value!!,  position)
    }

    init {
        mManagerSpecialsList.observe(fragment, Observer<ManagerSpecialsList> {
            this.notifyDataSetChanged()
        })

        //TODO Load initial data from repository, async
        ManagerSpecialsRepository().specials(mManagerSpecialsList)
    }

    /**
     * ViewHolder for CardView row UI. Each displayed row of ManagerSpecial data corresponds to one ViewHolder
     */
    inner class ManagerSpecialsCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var listView: View = view


        /**
         * Bind data from a Manager's Specials item to a list row
         */
        fun bindProduct(managerSpecialList: ManagerSpecialsList, position: Int) {
            val product = managerSpecialList.managerSpecials[position]
            val layout = ConstraintLayout.LayoutParams(mWidthPixels / managerSpecialList.canvasUnit * product.width,
                mWidthPixels / managerSpecialList.canvasUnit * product.height)
            with (listView) {
                layoutParams = layout
                Picasso.get().load(product.imageUrl).into(productImage)  //Load product image async in the background
                retail_price.text = product.retailPrice.toLocalCurrency()
                retail_price.setPaintFlags(retail_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                price.text = product.price.toLocalCurrency()
                product_name.text = product.productName
            }
        }
    }
}
