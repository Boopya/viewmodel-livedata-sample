package com.mizu.viewmodellivedatasamp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val text: MutableLiveData<String> = MutableLiveData()
    private val itemsLiveData: MutableLiveData<List<String>> = MutableLiveData()
    private val items: MutableList<String> = ArrayList(listOf("Apple", "Banana", "Strawberry"))

    fun getText(): LiveData<String> {
        text.value = "Initial text."
        return text
    }

    fun setText(newText: String) {
        text.value = newText
    }

    fun getItems(): LiveData<List<String>> {
        itemsLiveData.value = items
        return itemsLiveData
    }

    fun addItem(item: String) {
        items.add(item)
        itemsLiveData.value = items
    }

    fun deleteItem(item: String) {
        items.remove(item)
        itemsLiveData.value = items
    }
}