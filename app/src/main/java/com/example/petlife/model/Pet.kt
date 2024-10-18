package com.example.petlife.model

import java.io.Serializable

enum class Species(val speciesName: String) {
    CAO("Cão"),
    GATO("Gato");

    override fun toString(): String {
        return speciesName
    }
}

enum class Sizes(val sizeName: String) {
    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande");

    override fun toString(): String {
        return sizeName
    }
}

data class Pet(
    var name: String,
    var birthDate: String,
    var species: Species,
    var color: String,
    var size: Sizes,
    var lastVeterinarianSeen: String,
    var lastPetShopDate: String,
    var lastVacinationDate: String
) : Serializable
