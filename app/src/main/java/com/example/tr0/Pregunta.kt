data class Pregunta(
    val id: Int,
    val pregunta: String,
    val respostes: List<Respuesta>,
    val resposta_correcta: Int,
    val encerts: Int,
    val intents: Int,
    val imatge: String
)

data class Respuesta(
    val text: String,
    val imatge: String
)
