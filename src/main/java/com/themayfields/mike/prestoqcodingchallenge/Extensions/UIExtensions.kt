package com.themayfields.mike.prestoqcodingchallenge.Extensions

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

////////////////////////////////////////////////////////
//  Extension methods for Android UI-Related classes  //
////////////////////////////////////////////////////////

/*
 * Extension to inflate a layout into a view group
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
