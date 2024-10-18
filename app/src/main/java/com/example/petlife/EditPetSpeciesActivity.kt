package com.example.petlife

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.databinding.ActivityEditPetSpecieBinding
import com.example.petlife.model.Pet
import com.example.petlife.model.Species

class EditPetSpeciesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPetSpecieBinding
    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetSpecieBinding.inflate(layoutInflater)
        setContentView(binding.root)


        pet = intent.getSerializableExtra("pet") as Pet


        val speciesList = Species.values().map { it.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, speciesList)
        binding.spinnerSpecies.adapter = adapter


        binding.spinnerSpecies.setSelection(speciesList.indexOf(pet.species.name))


        binding.btnSave.setOnClickListener {
            val selectedSpecies = Species.valueOf(binding.spinnerSpecies.selectedItem.toString())
            pet.species = selectedSpecies


            val resultIntent = Intent()
            resultIntent.putExtra("pet", pet)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
