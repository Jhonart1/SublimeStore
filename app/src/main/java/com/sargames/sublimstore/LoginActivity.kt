package com.sargames.sublimstore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sargames.sublimstore.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // Ocultar la barra de título
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                // Mostrar mensaje de error si los campos están vacíos
                android.widget.Toast.makeText(this, "Por favor complete todos los campos", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Aquí se implementará la lógica de autenticación real
            // Por ahora solo validamos que los campos no estén vacíos
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.registerTextView.setOnClickListener {
            //Se navega a la pantalla de registro
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
} 