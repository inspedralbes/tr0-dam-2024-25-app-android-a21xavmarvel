package Conexion


import ProgramaDatos.Pregunta
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/preguntes")
    suspend fun obtenerPreguntas(): List<Pregunta>

}

