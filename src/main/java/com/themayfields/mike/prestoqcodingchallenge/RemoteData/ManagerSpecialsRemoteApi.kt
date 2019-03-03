package com.themayfields.mike.prestoqcodingchallenge.RemoteData

import com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel.ManagerSpecialsProduct
import com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel.Money

class ManagerSpecialsRemoteApi {

    fun fetchManagerSpecialsFromServer() {
        //TODO Use network and serialized classes
        val products : List<ManagerSpecialsProduct> = listOf(
            ManagerSpecialsProduct("https://raw.githubusercontent.com/prestoqinc/code-exercise-android/master/images/L.png",
                10, 8,"Kikkoman Less Sodium Soy Sauce", Money("2.00"), Money("1.00")
            ),
            ManagerSpecialsProduct("https://raw.githubusercontent.com/prestoqinc/code-exercise-android/master/images/K.png",
                14, 8,"Some other product with a long name that should wrap and ellipsize", Money("3.00"), Money("1.00")
            )
        )
    }
}