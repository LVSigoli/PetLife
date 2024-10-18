package com.example.petlife

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.petlife.databinding.ActivityEditPetVetBinding

import com.example.petlife.model.Pet

class EditiVetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPetVetBinding
    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetVetBinding.inflate(layoutInflater)
        setContentView(binding.root)


        pet = intent.getSerializableExtra("pet") as Pet

        binding.etPetVet.setText(pet.lastVeterinarianSeen)

        binding.btnSave.setOnClickListener {
            pet.lastVeterinarianSeen = binding.etPetVet.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("pet", pet)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
