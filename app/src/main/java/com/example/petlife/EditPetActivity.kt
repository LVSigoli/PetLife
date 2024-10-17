package com.example.petlife

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.databinding.ActivityEditPetBinding
import com.example.petlife.model.Pet

class EditPetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPetBinding
    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetBinding.inflate(layoutInflater)
        setContentView(binding.root)


        pet = intent.getSerializableExtra("pet") as Pet

        binding.etPetName.setText(pet.name)

        binding.btnSave.setOnClickListener {
            pet.name = binding.etPetName.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("pet", pet)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
