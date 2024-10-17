package com.example.tr0

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val scoreTextView: TextView = findViewById(R.id.scoreTextView)
        val totalTimeTextView: TextView = findViewById(R.id.totalTimeTextView) // Asegúrate de tener este TextView en el XML
        val restartButton: Button = findViewById(R.id.restartButton)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        val totalTime = intent.getStringExtra("totalTime") // Obtener el tiempo total

        scoreTextView.text = "Tu puntuación es: $score / $total"
        totalTimeTextView.text = "Tiempo total: $totalTime" // Mostrar el tiempo total

        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
