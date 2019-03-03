package com.themayfields.mike.prestoqcodingchallenge.Repository

import android.arch.lifecycle.MutableLiveData
import com.themayfields.mike.prestoqcodingchallenge.Cache.ManagerSpecialsCache
import com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel.ManagerSpecialsList
import com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel.ManagerSpecialsProduct
import com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel.Money

class ManagerSpecialsRepository {
    fun specials(result: MutableLiveData<ManagerSpecialsList>) {
        var specials = ManagerSpecialsCache.cachedValue
        if (specials == null) {
            specials = defaultSpecials()
            ManagerSpecialsCache.cachedValue = specials
            loadSpecialsAsync()
        }
        result.value = specials
    }

    private fun defaultSpecials() : ManagerSpecialsList {
        val products : List<ManagerSpecialsProduct> = listOf(
            ManagerSpecialsProduct("https://raw.githubusercontent.com/prestoqinc/code-exercise-android/master/images/L.png",
                10, 8,"Kikkoman Less Sodium Soy Sauce", Money("2.00"), Money("1.00")
            ),
            ManagerSpecialsProduct("https://raw.githubusercontent.com/prestoqinc/code-exercise-android/master/images/K.png",
                14, 8,"Some other product with a long name that should wrap and ellipsize", Money("3.00"), Money("1.00")
            )
        )
        return ManagerSpecialsList(16, products)
    }

    private fun loadSpecialsAsync() {
        //TODO Load from database, then load from network, async
    }
}