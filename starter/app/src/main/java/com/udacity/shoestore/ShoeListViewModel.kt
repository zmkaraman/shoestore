package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {


    private var _shoelist = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoelist

    // The new shoe
    private var _shoe = MutableLiveData<Shoe>()
    val shoe : LiveData<Shoe>
        get() = _shoe


    private var _eventShoeAdd = MutableLiveData<Boolean>()
    val eventShoeAdd : LiveData<Boolean>
        get() = _eventShoeAdd

    init {
        //_shoe.value = newShoe
        //Log.i("ScoreViewModel","New shoe is ${newShoe.name}")

        _shoelist.value = mutableListOf(
            Shoe("Sports Arizona", 41.0, "Nike", "asdasdada adadad"),
            Shoe("Kids' ZMK", 39.0, "Adidas", "asdasdada adadad"),
            Shoe("Nike Air Jordan", 39.0, "Nike", "asdasdada adadad"),
            Shoe("Gone in 60 Seconds", 39.0, "Nike", "asdasdada adadad"),
            Shoe("Tennis shoes", 39.0, "Nike", "asdasdada adadad"),
            Shoe("The Wic Boots", 39.0, "Nike", "asdasdada adadad"),
            Shoe("Rider Bootie", 39.0, "D&G", "asdasdada adadad"),
            Shoe("Classic Boots", 43.0, "Caterpillar", "asdasdada adadad")
        )

    }

    fun addShoe(shoe: Shoe) {
        _shoelist.value?.add(shoe)
        _eventShoeAdd.value = true

    }

    fun onShoePreAdd() {
        _shoelist.value?.plus(_shoe.value)
        _eventShoeAdd.value = true
    }

    fun onShoeAdded() {
        _eventShoeAdd.value = false
    }




}