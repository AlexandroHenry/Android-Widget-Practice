package com.example.widgetpractice.data

data class RecyclerData(
    val name: String,
    val ticker: String,
    var price: Double,
    var low: Double,
    var high: Double,
    var volume: Int
)
