package com.themayfields.mike.prestoqcodingchallenge.Model.APIModel

/**
 * Product in a manager's special list, as received from web service API
 */
data class ManagerSpecialsProductAPI (
    val imageUrl: String,  //URL of image to display
    val width: Int,
    val height: Int,
    val displayName: String,
    val originalPrice: String,
    val price: String
)
