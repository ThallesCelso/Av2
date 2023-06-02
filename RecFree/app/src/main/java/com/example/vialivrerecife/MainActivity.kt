package com.example.vialivrerecife

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vialivrerecife.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {entrar()}
    }

    private fun entrar() {
       val nome = binding.user.text.toString()

        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("nome", nome)
        startActivity(intent)

        val database = Firebase.database
        val myRef = database.getReference("teste")

        myRef.setValue("Hello, World!")
    }
}


