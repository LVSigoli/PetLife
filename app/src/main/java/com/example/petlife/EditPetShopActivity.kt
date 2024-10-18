package com.example.petlife

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.databinding.ActivityEditPetPetshopBinding

import com.example.petlife.model.Pet

class EditPetShopActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPetPetshopBinding
    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetPetshopBinding.inflate(layoutInflater)
        setContentView(binding.root)


        pet = intent.getSerializableExtra("pet") as Pet

        binding.etPetPetShop.setText(pet.lastPetShopDate)

        binding.btnSave.setOnClickListener {
            pet.lastPetShopDate = binding.etPetPetShop.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("pet", pet)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
