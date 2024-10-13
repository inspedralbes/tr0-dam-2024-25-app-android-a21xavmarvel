package Programa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proy1.R
import kotlinx.coroutines.launch

class QuestionActivity : AppCompatActivity() {
    private lateinit var preguntasRepository: PreguntasRepository
    private lateinit var recyclerView: RecyclerView
    private lateinit var preguntasAdapter: PreguntasAdapter // Un adaptador para el RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        preguntasRepository = PreguntasRepository()
        recyclerView = findViewById(R.id.recyclerViewPreguntas) // Asegúrate de que este ID esté en tu layout
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            preguntasRepository.cargarPreguntas()
            mostrarPreguntas()
        }
    }

    private fun mostrarPreguntas() {
        val preguntasList = preguntasRepository.getPreguntas()
        preguntasAdapter = PreguntasAdapter(preguntasList) // Crear adaptador con la lista de preguntas
        recyclerView.adapter = preguntasAdapter
    }
}
