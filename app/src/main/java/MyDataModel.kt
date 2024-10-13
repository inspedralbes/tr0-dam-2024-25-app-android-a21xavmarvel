data class Resposta(
    val text: String,
    val imatge: String
)

data class MyDataModel(
    val id: Int,
    val pregunta: String,
    val respostes: List<Resposta>,
    val resposta_correcta: Int,
    val imatge: String
)


