package com.example.petlife

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.databinding.ActivityEditPetBinding
import com.example.petlife.model.Pet
import com.example.petlife.model.Sizes
import com.example.petlife.model.Species

class EditPetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPetBinding
    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetBinding.inflate(layoutInflater)
        setContentView(binding.root)


        pet = intent.getSerializableExtra("pet") as Pet


        binding.etPetName.setText(pet.name)
        binding.etPetColor.setText(pet.color)
        binding.etPetBirth.setText(pet.birthDate)


        val sizesOptions = Sizes.values().map { it.name }
        val sizesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sizesOptions)
        sizesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSizes.adapter = sizesAdapter


        binding.spinnerSizes.setSelection(Sizes.values().indexOf(pet.size))


        val speciesOptions = Species.values().map { it.name }
        val speciesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, speciesOptions)
        speciesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSpecies.adapter = speciesAdapter


        binding.spinnerSpecies.setSelection(Species.values().indexOf(pet.species))


        binding.btnSave.setOnClickListener {

            pet.name = binding.etPetName.text.toString()
            pet.color = binding.etPetColor.text.toString()
            pet.birthDate = binding.etPetBirth.text.toString()


            val selectedSizePosition = binding.spinnerSizes.selectedItemPosition
            pet.size = Sizes.values()[selectedSizePosition]


            val selectedSpeciesPosition = binding.spinnerSpecies.selectedItemPosition
            pet.species = Species.values()[selectedSpeciesPosition]


            val resultIntent = Intent()
            resultIntent.putExtra("pet", pet)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
