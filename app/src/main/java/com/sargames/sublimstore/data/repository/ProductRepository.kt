package com.sargames.sublimstore.data.repository

import com.sargames.sublimstore.data.model.Product

class ProductRepository {
    fun getOffers(): List<Product> = listOf(
        Product(
            id = "1",
            name = "Taza Día del Padre",
            description = "Taza personalizada para el día del padre",
            price = 15000.0,
            imageUrl = "https://acortar.link/GBepD7",
            category = "Ofertas",
            isOffer = true,
            originalPrice = 20000.0
        ),
        Product(
            id = "2",
            name = "Taza Día de la Madre",
            description = "Taza personalizada para el día de la madre",
            price = 15000.0,
            imageUrl = "https://acortar.link/GBepD7",
            category = "Ofertas",
            isOffer = true,
            originalPrice = 20000.0
        ),
        Product(
            id = "3",
            name = "Taza San Valentín",
            description = "Taza personalizada para San Valentín",
            price = 18000.0,
            imageUrl = "https://acortar.link/GBepD7",
            category = "Ofertas",
            isOffer = true,
            originalPrice = 25000.0
        )
    )

    fun getFeatured(): List<Product> = listOf(
        Product(
            id = "4",
            name = "Taza Personalizada",
            description = "Taza con diseño personalizado",
            price = 20000.0,
            imageUrl = "https://acortar.link/GBepD7",
            category = "Destacados"
        ),
        Product(
            id = "5",
            name = "Taza Gamer",
            description = "Taza con diseño gamer",
            price = 22000.0,
            imageUrl = "https://acortar.link/GBepD7",
            category = "Destacados"
        ),
        Product(
            id = "6",
            name = "Taza Minimalista",
            description = "Taza con diseño minimalista",
            price = 18000.0,
            imageUrl = "https://acortar.link/GBepD7",
            category = "Destacados"
        )
    )

    fun getCatalog(): List<Product> = listOf(
        Product(
            id = "7",
            name = "Taza Navideña",
            description = "Taza con diseño navideño",
            price = 20000.0,
            imageUrl = "https://acortar.link/GBepD7",
            category = "Catálogo",
            specialDay = "Navidad"
        ),
        Product(
            id = "8",
            name = "Taza Halloween",
            description = "Taza con diseño de Halloween",
            price = 20000.0,
            imageUrl = "https://acortar.link/GBepD7",
            category = "Catálogo",
            specialDay = "Halloween"
        ),
        Product(
            id = "9",
            name = "Taza Día del Amor",
            description = "Taza con diseño romántico",
            price = 20000.0,
            imageUrl = "https://acortar.link/GBepD7",
            category = "Catálogo",
            specialDay = "San Valentín"
        )
    )
} 