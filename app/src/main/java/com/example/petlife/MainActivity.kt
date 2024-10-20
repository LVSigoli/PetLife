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
        "Rex", "01/01/2020", Species.CAO, "Marrom", Sizes.MEDIO,
        "10/10/2023", "12/09/2023", "05/05/2023"
    )

    private lateinit var editPetLauncher: ActivityResultLauncher<Intent>
    private lateinit var editPetColorLauncher: ActivityResultLauncher<Intent>
    private lateinit var editPetBirthLauncher: ActivityResultLauncher<Intent>
    private lateinit var editPetVacinLauncher: ActivityResultLauncher<Intent>
    private lateinit var editPetVetLauncher: ActivityResultLauncher<Intent>
    private lateinit var editPetShopLauncher: ActivityResultLauncher<Intent>
    private lateinit var editPetSizeLauncher: ActivityResultLauncher<Intent>
    private lateinit var editPetSpeciesLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayPetData()

        editPetLauncher = registerLauncher()
        editPetColorLauncher = registerLauncher()
        editPetBirthLauncher = registerLauncher()
        editPetVacinLauncher = registerLauncher()
        editPetShopLauncher = registerLauncher()
        editPetVetLauncher = registerLauncher()
        editPetSizeLauncher = registerLauncher()
        editPetSpeciesLauncher = registerLauncher()

        binding.btnEditPet.setOnClickListener { editPetBinding() }


        binding.btnEditVacinacao.setOnClickListener { editVacinBinding() }
        binding.btnEditVet.setOnClickListener { editVetBinding() }
        binding.btnEditPetshop.setOnClickListener { editPetShopBinding() }

    }

    // Functions
    private fun registerLauncher(): ActivityResultLauncher<Intent> {
        return registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val updatedPet = result.data?.getSerializableExtra("pet") as? Pet
                updatedPet?.let {
                    pet = it
                    displayPetData()
                }
            }
        }
    }

    private fun editPetBinding() {
        val intent = Intent(this, EditPetActivity::class.java)
        intent.putExtra("pet", pet)
        editPetLauncher.launch(intent)
    }



    private fun editVacinBinding() {
        val intent = Intent(this, EditiVacinationActivity::class.java)
        intent.putExtra("pet", pet)
        editPetVacinLauncher.launch(intent)
    }

    private fun editVetBinding() {
        val intent = Intent(this, EditiVetActivity::class.java)
        intent.putExtra("pet", pet)
        editPetVetLauncher.launch(intent)
    }

    private fun editPetShopBinding() {
        val intent = Intent(this, EditPetShopActivity::class.java)
        intent.putExtra("pet", pet)
        editPetShopLauncher.launch(intent)
    }





    @SuppressLint("SetTextI18n")
    private fun displayPetData() {
        binding.tvNome.text = "Nome: ${pet.name}"

        binding.tvTipo.text = "Espécie: ${pet.species}"

        binding.tvCor.text = "Cor: ${pet.color}"

        binding.tvPorte.text = "Porte: ${pet.size}"

        binding.tvDataNascimento.text = "Data de nascimento: ${pet.birthDate}"

        binding.tvUltimaPetshop.text = "Última ida ao petshop: ${pet.lastPetShopDate}"

        binding.tvUltimaVet.text = "Última ida ao veterinário: ${pet.lastVeterinarianSeen}"

        binding.tvUltimaVacinacao.text = "Última vacinação em: ${pet.lastVacinationDate}"
    }

}
