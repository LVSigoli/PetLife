package com.example.petlife.model

enum class Species {
    DOG, CAT
}

enum class Sizes{ SMALL, MEDIUM, BIG}


data class Pet (var name: String,
    var birthDate: String,
    var species: Species,
    var color: String,
    var size: Sizes,
    var lastVeterinarianSeen: String,
    var lastPetShopDate: String,
    var lastVacinationDate: String
)


