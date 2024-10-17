package com.example.petlife

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.databinding.ActivityMainBinding
import com.example.petlife.model.Pet
import com.example.petlife.model.Sizes
import com.example.petlife.model.Species

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var pet = Pet(
        "Rex", "01/01/2020", Species.DOG, "Marrom", Sizes.MEDIUM,
        "10/10/2023", "12/09/2023", "05/05/2023"
    )

    override fun onCreate(saveinstancestate: Bundle?){
        super.onCreate(saveinstancestate)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayPetData()

    }

    private fun displayPetData(){
        binding.tvNome.text = "Nome: " + pet.name

        binding.tvDataNascimento.text = "Data de nascimento: "+ pet.birthDate

        binding.tvTipo.text = "Espécie: " + pet.species.toString()

        binding.tvCor.text = "Cor: " + pet.color

        binding.tvPorte.text = "Porte: "+ pet.size.toString()

        binding.tvUltimaVet.text ="Ultima ida ao veterinário: "+  pet.lastVeterinarianSeen

        binding.tvUltimaPetshop.text ="Ultima ida ao petshop: "+ pet.lastPetShopDate

        binding.tvUltimaVacinacao.text = "Ultima vacinação em: "+ pet.lastVacinationDate
    }



}


