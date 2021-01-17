package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private var _shoelist = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoelist


    private var _eventShoeAdd = MutableLiveData<Boolean>()
    val eventShoeAdd : LiveData<Boolean>
        get() = _eventShoeAdd

    init {

        _shoelist.value = mutableListOf(
            Shoe("Sports Arizona", 41.0, "Adidas", "Best for sports"),
            Shoe("Nike Air Jordan", 39.5, "Nike", "Popular choice for basketball"),
            Shoe("Tennis shoes", 39.0, "Nike", "Best for tennis "),
            Shoe("The Wic Boots", 35.0, "Nine West", "Best for sports"),
            Shoe("Rider Bootie", 39.0, "Nine West", "Fashionable and comfortable"),
            Shoe("Classic Boots", 43.5, "Caterpillar", "Casual and comfortable")
        )

    }

    fun addShoe(shoe: Shoe) {
        _shoelist.value?.add(shoe)
        _eventShoeAdd.value = true

    }

}