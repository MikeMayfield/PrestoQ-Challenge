package com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel

/**
 * Definition of a list of manager's specials
 */
data class ManagerSpecialsList (
    val canvasUnit: Int,  //Number of segments in display canvas
    val managerSpecials: List<ManagerSpecialsProduct>  //List of manager special products to display
)