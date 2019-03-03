package com.themayfields.mike.prestoqcodingchallenge.Cache

import com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel.ManagerSpecialsList

class ManagerSpecialsCache {

    companion object {
        var cache : ManagerSpecialsList? = null

        var cachedValue: ManagerSpecialsList?
            get() {
                return cache
            }
            set(value) {
                cache = value
            }

    }
}