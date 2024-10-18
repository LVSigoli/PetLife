package com.example.petlife

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.databinding.ActivityEditPetBirthBinding

import com.example.petlife.model.Pet

class EditBirthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPetBirthBinding
    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetBirthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        pet = intent.getSerializableExtra("pet") as Pet

        binding.etPetBirth.setText(pet.birthDate)

        binding.btnSave.setOnClickListener {
            pet.birthDate = binding.etPetBirth.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("pet", pet)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
