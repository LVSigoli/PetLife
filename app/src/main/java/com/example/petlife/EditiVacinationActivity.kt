package com.example.petlife

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.databinding.ActivityEditPetBirthBinding
import com.example.petlife.databinding.ActivityEditPetVacBinding

import com.example.petlife.model.Pet

class EditiVacinationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPetVacBinding
    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetVacBinding.inflate(layoutInflater)
        setContentView(binding.root)


        pet = intent.getSerializableExtra("pet") as Pet

        binding.etPetVac.setText(pet.lastVacinationDate)

        binding.btnSave.setOnClickListener {
            pet.lastVacinationDate = binding.etPetVac.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("pet", pet)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
