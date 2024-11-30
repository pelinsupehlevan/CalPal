package com.example.calpal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodViewModel : ViewModel() {
    private var _changeCal = MutableLiveData<Int>(0)

    private var _cal = MutableLiveData<Int>(0)

    private var _foodName = MutableLiveData<String>()

    fun setChangeCalorie(newCal: Int) {
        _changeCal.value = newCal
    }

    val calorie: LiveData<Int>
        get() = _cal

    fun setCalorie(newCal: Int) {
        _cal.value = newCal
    }

    fun changeCalorie() {
        _cal.value = _cal.value!! + _changeCal.value!!
        _changeCal.value = 0}
}