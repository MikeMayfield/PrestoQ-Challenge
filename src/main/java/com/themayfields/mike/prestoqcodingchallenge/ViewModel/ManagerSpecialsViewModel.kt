package com.themayfields.mike.prestoqcodingchallenge.ViewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel.ManagerSpecialsList

class ManagerSpecialsViewModel : ViewModel() {
    private var managerSpecialsList = MutableLiveData<ManagerSpecialsList>()

    companion object{
        fun create(activity: Fragment): ManagerSpecialsViewModel{
            return ViewModelProviders.of(activity).get(ManagerSpecialsViewModel::class.java)
        }
    }

    init {
        //TODO Get data from the repository
    }

    fun setSpecialsList(value : ManagerSpecialsList) {
        managerSpecialsList.value = value
    }

    fun getSpecialsList() : LiveData<ManagerSpecialsList> {
        return managerSpecialsList
    }
}