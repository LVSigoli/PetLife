package com.example.petlife

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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

    private lateinit var editPetLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayPetData()

        editPetLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {

                val updatedPet = result.data?.getSerializableExtra("pet") as? Pet
                updatedPet?.let {
                    pet = it
                    displayPetData()
                }
            }
        }

        binding.btnEditPet.setOnClickListener { editPetBinding() }
    }

    private fun editPetBinding() {
        val intent = Intent(this, EditPetActivity::class.java)
        intent.putExtra("pet", pet)

        editPetLauncher.launch(intent)
    }

    @SuppressLint("SetTextI18n")
    private fun displayPetData() {
        binding.tvNome.text = "Nome: " + pet.name
        binding.tvDataNascimento.text = "Data de nascimento: " + pet.birthDate
        binding.tvTipo.text = "Espécie: " + pet.species.toString()
        binding.tvCor.text = "Cor: " + pet.color
        binding.tvPorte.text = "Porte: " + pet.size.toString()
        binding.tvUltimaVet.text = "Ultima ida ao veterinário: " + pet.lastVeterinarianSeen
        binding.tvUltimaPetshop.text = "Ultima ida ao petshop: " + pet.lastPetShopDate
        binding.tvUltimaVacinacao.text = "Ultima vacinação em: " + pet.lastVacinationDate
    }
}
