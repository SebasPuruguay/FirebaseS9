package com.example.firebases9.Model

data class ProductApiModel(
    val id: String = "",
    val description: String= "",
    val imageUrl: String= "",
    val stock: Int,
    val price: Double,
    val discount: Double,
    val categoryId: Int,

)
