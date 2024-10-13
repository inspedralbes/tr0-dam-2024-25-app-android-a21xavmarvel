package com.example.proy1

import ProgramaDatos.Pregunta
import ProgramaDatos.Respuesta
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.unit.dp
import com.example.proy1.ui.theme.Proy1Theme

// Simula la carga de datos desde un servidor o archivo local (JSON)
val preguntasJSON = listOf(
    Pregunta(1, "Quina marca de cotxes utilitza el lema 'Ultimate Driving Machine'?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("BMW", true, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/BMW.svg/1200px-BMW.svg.png"),
            Respuesta("Mercedes-Benz", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Mercedes-Benz_Star_2022.svg/800px-Mercedes-Benz_Star_2022.svg.png"),
            Respuesta("Audi", false, "https://todosobrelogos.com/wp-content/uploads/2023/01/Audi-Logo.png"),
            Respuesta("Lexus", false, "https://logos-world.net/wp-content/uploads/2021/10/Lexus-Logo.png")
        )),

    Pregunta(2, "Quina marca és famosa per les seves sabates de sport amb el logotip d'un swoosh?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("Adidas", false, "https://ams3.digitaloceanspaces.com/graffica/2022/12/adidas_318-565831.webp"),
            Respuesta("Puma", false, "https://1000logos.net/wp-content/uploads/2021/04/Puma-logo.png"),
            Respuesta("Nike", true, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Logo_NIKE.svg/2560px-Logo_NIKE.svg.png"),
            Respuesta("Reebok", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Reebok_2019_logo.svg/2560px-Reebok_2019_logo.svg.png")
        )),

    Pregunta(3, "Quina marca de refrescs és coneguda pel seu logotip vermell i blanc?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("Pepsi", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Pepsi_logo_2014.svg/754px-Pepsi_logo_2014.svg.png"),
            Respuesta("Coca-Cola", true, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Coca-Cola_logo.svg/1024px-Coca-Cola_logo.svg.png"),
            Respuesta("Sprite", false, "https://i.pinimg.com/originals/14/84/74/14847430454dcd39a77c7579c763a31d.png"),
            Respuesta("Fanta", false, "https://upload.wikimedia.org/wikipedia/commons/c/c2/Fanta_logo_%282016%29.png")
        )),

    Pregunta(4, "Quina marca de tecnologia és famosa pels seus telèfons i ordinadors Mac?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("Microsoft", false, "https://www.insights.la/wp-content/uploads/2015/04/Microsoft-logo-m-box-880x660.png"),
            Respuesta("Apple", true, "https://1000logos.net/wp-content/uploads/2016/10/Apple-Logo.png"),
            Respuesta("Samsung", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Samsung_Logo.svg/2560px-Samsung_Logo.svg.png"),
            Respuesta("Sony", false, "https://1000marcas.net/wp-content/uploads/2020/01/logo-Sony.png")
        )),

    Pregunta(5, "Quina marca de menjar ràpid és famosa pel seu logotip amb un pal de hamburguesa?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("McDonald's", true, "https://brandemia.org/contenido/subidas/2022/10/marca-mcdonalds-logo.png"),
            Respuesta("Burger King", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Burger_King_2020.svg/1879px-Burger_King_2020.svg.png"),
            Respuesta("KFC", false, "https://upload.wikimedia.org/wikipedia/sco/thumb/b/bf/KFC_logo.svg/1200px-KFC_logo.svg.png"),
            Respuesta("Wendy's", false, "https://1000marcas.net/wp-content/uploads/2020/10/Wendys-logo.png")
        )),

    Pregunta(6, "Quina marca d'electrònica és coneguda per les seves televisions i consoles de videojocs?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("Sony", true, "https://cdn.icon-icons.com/icons2/3915/PNG/512/sony_logo_icon_249569.png"),
            Respuesta("LG", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/LG_logo_%282014%29.svg/600px-LG_logo_%282014%29.svg.png"),
            Respuesta("Samsung", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Samsung_Logo.svg/2560px-Samsung_Logo.svg.png"),
            Respuesta("Panasonic", false, "https://logodownload.org/wp-content/uploads/2017/05/panasonic-logo-0.png")
        )),

    Pregunta(7, "Quina marca de roba és famosa pel seu logotip amb un cavall?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("Lacoste", false, "https://logos-world.net/wp-content/uploads/2020/09/Lacoste-Logo.png"),
            Respuesta("Ralph Lauren", true, "https://logos-world.net/wp-content/uploads/2020/04/Ralph-Lauren-Logo.png"),
            Respuesta("Tommy Hilfiger", false, "https://logos-world.net/wp-content/uploads/2020/04/Tommy-Hilfiger-Logo.png"),
            Respuesta("Calvin Klein", false, "https://i.pinimg.com/736x/b3/24/af/b324af70cec38d694df892d2ad474d92.jpg")
        )),

    Pregunta(8, "Quina marca de perfums és coneguda pel seu logotip d'un got amb una tapa?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("Chanel", true, "https://upload.wikimedia.org/wikipedia/en/thumb/9/92/Chanel_logo_interlocking_cs.svg/1280px-Chanel_logo_interlocking_cs.svg.png"),
            Respuesta("Dior", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Dior_Logo.svg/2560px-Dior_Logo.svg.png"),
            Respuesta("Versace", false, "https://www.batesmeron.com/wp-content/uploads/Versace.png"),
            Respuesta("Gucci", false, "https://logos-world.net/wp-content/uploads/2020/04/Gucci-Logo.png")
        )),

    Pregunta(9, "Quina marca de càmeres és famosa per les seves càmeres réflex?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("Nikon", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Nikon_Logo.svg/512px-Nikon_Logo.svg.png"),
            Respuesta("Canon", true, "https://logos-world.net/wp-content/uploads/2020/08/Canon-Logo.png"),
            Respuesta("Fujifilm", false, "https://asset.fujifilm.com/www/es/files/2021-03/f311886a76f1c93272fa181656346f34/logo_06.jpg"),
            Respuesta("Sony", false, "https://cdn.icon-icons.com/icons2/3915/PNG/512/sony_logo_icon_249569.png")
        )),

    Pregunta(10, "Quina marca de pastisseria és coneguda pels seus donuts?",
        "https://img.freepik.com/psd-gratis/representacion-3d-preguntas-fondo_23-2151455632.jpg",
        listOf(
            Respuesta("Dunkin' Donuts", true, "https://i.pinimg.com/originals/5a/f4/2b/5af42b2e31010a24ac46d2cb5a0e60a6.png"),
            Respuesta("Krispy Kreme", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Krispy_Kreme_logo.svg/2560px-Krispy_Kreme_logo.svg.png"),
            Respuesta("Tim Hortons", false, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Tim_Hortons_logo.svg/2560px-Tim_Hortons_logo.svg.png"),
            Respuesta("Starbucks", false, "https://upload.wikimedia.org/wikipedia/en/thumb/d/d3/Starbucks_Corporation_Logo_2011.svg/640px-Starbucks_Corporation_Logo_2011.svg.png")
        ))
)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proy1Theme {
                var mostrarCuestionario by remember { mutableStateOf(false) }
                var mostrarResultados by remember { mutableStateOf(false) }
                var respuestasCorrectas by remember { mutableStateOf(0) }
                var respuestasIncorrectas by remember { mutableStateOf(0) }
                var tiempoTotal by remember { mutableStateOf(0L) }

                if (mostrarResultados) {
                    Resultados(respuestasCorrectas, respuestasIncorrectas, tiempoTotal) {
                        respuestasCorrectas = 0
                        respuestasIncorrectas = 0
                        tiempoTotal = 0
                        mostrarResultados = false
                        mostrarCuestionario = false
                    }
                } else if (mostrarCuestionario) {
                    Cuestionario(
                        onFinish = {
                            mostrarResultados = true
                        },
                        onCorrect = { respuestasCorrectas++ },
                        onIncorrect = { respuestasIncorrectas++ },
                        onStartTimer = { tiempoTotal = System.currentTimeMillis() }
                    )
                } else {
                    PantallaPrincipal(onJugarClick = {
                        mostrarCuestionario = true
                    })
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal(onJugarClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.channels4_profile),
            contentDescription = "Imagen de bienvenida",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Bienvenido al Cuestionario",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            onJugarClick()
        }) {
            Text(text = "Jugar")
        }
    }
}

@Composable
fun Cuestionario(onFinish: () -> Unit, onCorrect: () -> Unit, onIncorrect: () -> Unit, onStartTimer: () -> Unit) {
    var preguntaActualIndex by remember { mutableStateOf(0) }
    var respuestaSeleccionada by remember { mutableStateOf(-1) }
    val preguntas = preguntasJSON

    val hayMasPreguntas = preguntaActualIndex < preguntas.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (preguntaActualIndex == 0) {
            onStartTimer()
        }

        if (hayMasPreguntas) {
            val preguntaActual = preguntas[preguntaActualIndex]


            Image(
                painter = rememberAsyncImagePainter(preguntaActual.imagen),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = preguntaActual.pregunta,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            preguntaActual.respuestas.forEachIndexed { index, respuesta ->
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        respuestaSeleccionada = index

                        if (respuesta.correcta) {
                            onCorrect()
                        } else {
                            onIncorrect()
                        }

                        if (preguntaActualIndex < preguntas.size - 1) {
                            preguntaActualIndex++
                        } else {
                            onFinish()
                        }
                    }
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = rememberAsyncImagePainter(respuesta.imagen),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 8.dp),
                            contentScale = ContentScale.Fit
                        )
                        Text(text = respuesta.texto)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun Resultados(respuestasCorrectas: Int, respuestasIncorrectas: Int, tiempoTotal: Long, onReiniciar: () -> Unit) {
    val tiempoEnSegundos = (System.currentTimeMillis() - tiempoTotal) / 1000
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Has terminado el cuestionario!",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Respuestas correctas: $respuestasCorrectas",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Respuestas incorrectas: $respuestasIncorrectas",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "Tiempo total: $tiempoEnSegundos segundos",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            onReiniciar()
        }) {
            Text(text = "Volver a Jugar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Proy1Theme {
        PantallaPrincipal(onJugarClick = {})
    }
}


