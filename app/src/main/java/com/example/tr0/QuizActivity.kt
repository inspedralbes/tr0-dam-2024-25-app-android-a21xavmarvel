package com.example.tr0

import Respuesta
import Pregunta
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import coil.load
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class QuizActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var questionImageView: ImageView
    private lateinit var answersRadioGroup: RadioGroup
    private lateinit var nextButton: Button

    private var preguntas: List<Pregunta> = listOf()
    private var currentQuestionIndex = 0
    private var score = 0
    private var startTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionTextView = findViewById(R.id.questionTextView)
        questionImageView = findViewById(R.id.questionImageView)
        answersRadioGroup = findViewById(R.id.answersRadioGroup)
        nextButton = findViewById(R.id.nextButton)

        startTime = System.currentTimeMillis()

        obtenerPreguntas()

        nextButton.setOnClickListener {
            verificarRespuesta()
            currentQuestionIndex++
            if (currentQuestionIndex < preguntas.size) {
                mostrarPregunta()
            } else {
                mostrarResultado()
            }
        }
    }

    private fun obtenerPreguntas() = Thread {
        try {
            val url = URL("http://dam.inspedralbes.cat:25000/preguntes")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            val response = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                response.append(line)
            }
            reader.close()

            val jsonResponse = JSONObject(response.toString())
            val preguntesArray: JSONArray = jsonResponse.getJSONArray("preguntes")

            val preguntasList = mutableListOf<Pregunta>()

            for (i in 0 until preguntesArray.length()) {
                val preguntaObj = preguntesArray.getJSONObject(i)

                val respostesArray: JSONArray = preguntaObj.getJSONArray("respostes")
                val respostesList = mutableListOf<Respuesta>()

                for (j in 0 until respostesArray.length()) {
                    val respostaObj = respostesArray.getJSONObject(j)
                    val resposta = Respuesta(
                        respostaObj.getString("text"),
                        respostaObj.getString("imatge")
                    )
                    respostesList.add(resposta)
                }

                val id = if (preguntaObj.has("id") && !preguntaObj.isNull("id")) {
                    preguntaObj.getInt("id")
                } else {
                    0
                }

                val encerts = if (preguntaObj.has("encerts") && !preguntaObj.isNull("encerts")) {
                    preguntaObj.getInt("encerts")
                } else {
                    0
                }

                val intents = if (preguntaObj.has("intents") && !preguntaObj.isNull("intents")) {
                    preguntaObj.getInt("intents")
                } else {
                    0
                }

                val pregunta = Pregunta(
                    id = id,
                    pregunta = preguntaObj.getString("pregunta"),
                    respostes = respostesList,
                    resposta_correcta = preguntaObj.getInt("resposta_correcta"),
                    encerts = encerts,
                    intents = intents,
                    imatge = preguntaObj.optString("imatge", "")
                )
                preguntasList.add(pregunta)
            }

            preguntas = preguntasList

            runOnUiThread {
                mostrarPregunta()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }.start()

    private fun mostrarPregunta() {
        val preguntaActual = preguntas[currentQuestionIndex]
        questionTextView.text = preguntaActual.pregunta

        if (preguntaActual.imatge.isNotEmpty()) {
            questionImageView.load(preguntaActual.imatge)
        } else {
            questionImageView.setImageResource(0)
        }

        answersRadioGroup.removeAllViews()

        preguntaActual.respostes.forEachIndexed { index, respuesta ->
            val linearLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
            }

            val imageView = ImageView(this).apply {
                layoutParams = LinearLayout.LayoutParams(100, 100)
                load(respuesta.imatge)
            }

            val radioButton = RadioButton(this).apply {
                text = respuesta.text
                id = View.generateViewId()
            }

            radioButton.setOnClickListener {
                answersRadioGroup.check(radioButton.id)
                nextButton.isEnabled = true
            }

            linearLayout.addView(imageView)
            linearLayout.addView(radioButton)
            answersRadioGroup.addView(linearLayout)
        }

        nextButton.isEnabled = false
    }

    private fun verificarRespuesta() {
        val preguntaActual = preguntas[currentQuestionIndex]
        val selectedAnswerIndex = answersRadioGroup.checkedRadioButtonId
        if (selectedAnswerIndex == preguntaActual.resposta_correcta) {
            score++
        }
    }

    private fun mostrarResultado() {
        // Calcular el tiempo total
        val totalTimeMillis = System.currentTimeMillis() - startTime
        val totalTimeSeconds = totalTimeMillis / 1000
        val minutes = totalTimeSeconds / 60
        val seconds = totalTimeSeconds % 60
        val formattedTime = String.format("%02d:%02d", minutes, seconds)

        // Pasar el tiempo total a ResultActivity
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("score", score)
        intent.putExtra("total", preguntas.size)
        intent.putExtra("totalTime", formattedTime)
        startActivity(intent)
        finish()
    }
}
