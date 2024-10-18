package com.example.petlife

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.databinding.ActivityEditPetColorBinding
import com.example.petlife.model.Pet

class EditPetColorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPetColorBinding
    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetColorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        pet = intent.getSerializableExtra("pet") as Pet

        binding.etPetColor.setText(pet.color)

        binding.btnSave.setOnClickListener {
            pet.color = binding.etPetColor.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("pet", pet)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
