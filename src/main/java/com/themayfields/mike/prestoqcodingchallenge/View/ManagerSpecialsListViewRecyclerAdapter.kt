package com.themayfields.mike.prestoqcodingchallenge.View

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
import kotlinx.android.synthetic.main.manager_specials_list_view_item_row.view.*
import android.graphics.Paint


/**
 * Manager's Specials adapter RecyclerView Adapter for ListView-style view
 */
class ManagerSpecialsListViewRecyclerAdapter(val fragment: Fragment):
        RecyclerView.Adapter<ManagerSpecialsListViewRecyclerAdapter.ManagerSpecialsListViewHolder>() {

    var mManagerSpecialsList = MutableLiveData<ManagerSpecialsList>()

    override fun getItemCount(): Int {
        return mManagerSpecialsList.value?.managerSpecials?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ManagerSpecialsListViewHolder {
        val inflatedView = parent.inflate(com.themayfields.mike.prestoqcodingchallenge.R.layout.manager_specials_list_view_item_row, false)
        return ManagerSpecialsListViewHolder(inflatedView)
    }

    override fun onBindViewHolder(viewHolder: ManagerSpecialsListViewHolder, position: Int) {
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
     * ViewHolder for ListView row UI. Each displayed row of ManagerSpecial data corresponds to one ViewHolder
     */
    inner class ManagerSpecialsListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var listView: View = view

        /**
         * Bind data from a Manager's Specials list item to a list row
         */
        fun bindProduct(managerSpecialList: ManagerSpecialsList, position: Int) {
            val product = managerSpecialList.managerSpecials[position]
            with (listView) {
                Picasso.get().load(product.imageUrl).into(productImage)  //Load product image async in the background
                retail_price.text = product.retailPrice.toLocalCurrency()
                retail_price.setPaintFlags(retail_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                price.text = product.price.toLocalCurrency()
                product_name.text = product.productName
            }
        }
    }
}
