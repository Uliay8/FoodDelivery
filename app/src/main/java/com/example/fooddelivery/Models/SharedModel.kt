package com.example.fooddelivery.Models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedModel : ViewModel() {

    val cardItem = MutableLiveData<ArrayList<PopularModel>>()
    val buttonStates = ArrayList<Boolean>()

    fun getButtonStates() : List<Boolean>{
        return buttonStates
    }

    fun addToCard(item : PopularModel) {
        val currentCardItem = cardItem.value?: ArrayList<PopularModel>()
        currentCardItem.add(item)
        cardItem.value = currentCardItem
        buttonStates.add(true)
    }

    fun deleteFromCard(item : PopularModel) {
        val currentCardItem = cardItem.value?: ArrayList<PopularModel>()
        val index = currentCardItem.indexOf(item)
        if (index != -1) {
            currentCardItem.removeAt(index)
            cardItem.value = currentCardItem
            buttonStates.removeAt(index)
        }
    }

    fun inList(item : PopularModel) : Boolean {
        val currentCardItem = cardItem.value?: ArrayList<PopularModel>()
        return currentCardItem.contains(item)
    }

}