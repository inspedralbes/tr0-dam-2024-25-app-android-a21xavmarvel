package Programa

import Conexion.RetrofitClient
import ProgramaDatos.Pregunta

class PreguntasRepository {
    private val preguntasList = mutableListOf<Pregunta>()

    suspend fun cargarPreguntas() {
        try {
            preguntasList.clear()
            preguntasList.addAll(RetrofitClient.api.obtenerPreguntas())
        } catch (e: Exception) {
            // Manejo de errores, tal vez log o mensaje al usuario
        }
    }

    fun getPreguntas(): List<Pregunta> {
        return preguntasList
    }
}
