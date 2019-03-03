package com.themayfields.mike.prestoqcodingchallenge.Model.APIModel

/**
 * Manager's Special list, as received from the web service API
 *
 * The JSON format is as follows:
 * TODO
 */
data class ManagerSpecialsListApi (
    val canvasUnit: Int,  //Number of segments in display canvas
    val managerSpecials: List<ManagerSpecialsProductAPI>  //List of manager special products to display
)