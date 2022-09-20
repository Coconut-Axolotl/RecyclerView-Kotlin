package com.example.recyclerview_kotlin



class ItemTracker {

     companion object addItem {

        var itemList = mutableListOf<Items>()

        fun addItem(inputItem: Items) {
            itemList.add(inputItem)
        }

        fun getItems(): MutableList<Items> {
            return itemList

        }
    }
}


