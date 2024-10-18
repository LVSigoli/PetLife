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
    private lateinit var editPetColorLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayPetData()

        // Launcher para editar os dados do pet
        editPetLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val updatedPet = result.data?.getSerializableExtra("pet") as? Pet
                updatedPet?.let {
                    pet = it
                    displayPetData()
                }
            }
        }

        // Launcher para editar a cor do pet
        editPetColorLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val updatedPet = result.data?.getSerializableExtra("pet") as? Pet
                updatedPet?.let {
                    pet = it
                    displayPetData() // Atualiza a exibição com os dados do pet
                }
            }
        }

        binding.btnEditPet.setOnClickListener { editPetBinding() }
        binding.btnEditPetColor.setOnClickListener { editPetColorBinding() }
    }

    private fun editPetBinding() {
        val intent = Intent(this, EditPetActivity::class.java)
        intent.putExtra("pet", pet)
        editPetLauncher.launch(intent)
    }

    private fun editPetColorBinding() {
        val intent = Intent(this, EditPetColorActivity::class.java)
        intent.putExtra("pet", pet)
        editPetColorLauncher.launch(intent)  // Inicia a EditPetColorActivity
    }

    @SuppressLint("SetTextI18n")
    private fun displayPetData() {
        binding.tvNome.text = "Nome: ${pet.name}"
        binding.tvDataNascimento.text = "Data de nascimento: ${pet.birthDate}"
        binding.tvTipo.text = "Espécie: ${pet.species}"
        binding.tvCor.text = "Cor: ${pet.color}"
        binding.tvPorte.text = "Porte: ${pet.size}"
        binding.tvUltimaVet.text = "Última ida ao veterinário: ${pet.lastVeterinarianSeen}"
        binding.tvUltimaPetshop.text = "Última ida ao petshop: ${pet.lastPetShopDate}"
        binding.tvUltimaVacinacao.text = "Última vacinação em: ${pet.lastVacinationDate}"
    }
}
