package Programa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ProgramaDatos.Pregunta
import com.example.proy1.R

class PreguntasAdapter(private val preguntasList: List<Pregunta>) :
    RecyclerView.Adapter<PreguntasAdapter.PreguntasViewHolder>() {

    class PreguntasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoPregunta: TextView = itemView.findViewById(R.id.textoPregunta)
        val grupoRespuestas: RadioGroup = itemView.findViewById(R.id.grupoRespuestas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pregunta, parent, false)
        return PreguntasViewHolder(view)
    }

    override fun onBindViewHolder(holder: PreguntasViewHolder, position: Int) {
        val pregunta = preguntasList[position]
        holder.textoPregunta.text = pregunta.pregunta

        // Limpiar las respuestas anteriores
        holder.grupoRespuestas.removeAllViews()

        // Añadir las respuestas como RadioButtons
        pregunta.respuestas.forEach { respuesta ->
            val radioButton = RadioButton(holder.itemView.context)
            radioButton.text = respuesta.texto
            holder.grupoRespuestas.addView(radioButton)
        }
    }

    override fun getItemCount(): Int {
        return preguntasList.size
    }
}
