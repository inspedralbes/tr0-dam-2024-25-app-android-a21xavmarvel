package ProgramaDatos

data class Respuesta(
    val texto: String,
    val correcta: Boolean,
    val imagen: String
)

data class Pregunta(
    val id: Int,
    val pregunta: String,
    val imagen: String,
    val respuestas: List<Respuesta>
)
