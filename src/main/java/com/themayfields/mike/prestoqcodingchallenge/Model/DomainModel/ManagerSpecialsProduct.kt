package com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel

/**
 * Product in a manager's special list. Note the use of price and salePrice when used in a domain model that reflects
 * more abstract definitions of a product.
 */
data class ManagerSpecialsProduct (
    val imageUrl: String,  //URL of image to display
    val width: Int,  //Width of product display, in canvas units
    val height: Int,  //Height of product display, in canvas units
    val productName: String,  //Product name to display
    val retailPrice: Money,  //Original (retail) price
    val price: Money  //Current price
)
