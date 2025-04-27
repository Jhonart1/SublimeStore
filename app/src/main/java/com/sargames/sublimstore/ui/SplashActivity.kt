package com.sargames.sublimstore.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.sargames.sublimstore.MainActivity
import com.sargames.sublimstore.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 3000 // 3 segundos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Ocultar la barra de acción si está presente
        supportActionBar?.hide()

        // Configurar el delay y la navegación
        Handler(Looper.getMainLooper()).postDelayed({
            // Crear el intent para la actividad principal
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            
            // Cerrar el splash activity
            finish()
        }, SPLASH_DELAY)
    }
} 