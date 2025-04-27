package com.sargames.sublimstore.data.model

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val category: String,
    val isOffer: Boolean = false,
    val originalPrice: Double? = null,
    val specialDay: String? = null
) 