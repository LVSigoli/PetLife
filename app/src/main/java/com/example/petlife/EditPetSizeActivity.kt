package com.example.petlife

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.databinding.ActivityEditPetSizeBinding
import com.example.petlife.model.Pet
import com.example.petlife.model.Sizes

class EditPetSizeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPetSizeBinding
    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetSizeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obter o objeto Pet da Intent
        pet = intent.getSerializableExtra("pet") as Pet

        // Configurar o Spinner para Tamanhos
        val sizesOptions = Sizes.values().map { it.name } // Utilizando o nome dos tamanhos
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sizesOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSizes.adapter = adapter

        // Selecionar o tamanho atual do pet no Spinner
        binding.spinnerSizes.setSelection(Sizes.values().indexOf(pet.size))

        binding.btnSave.setOnClickListener {
            // Obter o tamanho selecionado do Spinner
            val selectedSizePosition = binding.spinnerSizes.selectedItemPosition
            pet.size = Sizes.values()[selectedSizePosition] // Atualizar o tamanho do pet

            // Retornar o objeto Pet atualizado
            val resultIntent = Intent()
            resultIntent.putExtra("pet", pet)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
