package com.antonio.ejemplo1composeridgs903

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla."),
    PersonajeTarjeta("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters"),
    PersonajeTarjeta("Piccolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación."),
    PersonajeTarjeta("Gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("Krillin", "Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball. Es uno de los principales discípulos de Kame-Sen'nin, Guerrero Z, y el mejor amigo de Son Goku."),
    PersonajeTarjeta("Gotenks", "Gotenks también conocido inicialmente como Gotrunk en el doblaje al español de España, es el resultado de la Danza de la Fusión llevada a cabo correctamente por Goten y Trunks."),
    PersonajeTarjeta("Bardock", "Es un saiyano de clase baja proveniente del Planeta Vegeta del Universo 7. "),
    PersonajeTarjeta("Android 17", "Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal"),
    PersonajeTarjeta("Jiren", "Jiren es un poderoso luchador del Universo 11 y uno de los oponentes más formidables en el torneo."),
    PersonajeTarjeta("Gogeta", "Gogeta es la fusión resultante de Son Goku y Vegeta, cuando realizan la Danza de la Fusión correctamente para enfrentarse a Broly."),
    PersonajeTarjeta("Vegetto", "Vegetto es el personaje más fuerte dentro del manga original y uno de los personajes más poderosos de toda la serie en general."),
    PersonajeTarjeta("Broly", "Broly es un Saiyajin que posee un poder gigantesco e incontrolable, el cual se manifiesta en toda su magnitud cuando se convierte en el Super Saiyajin Legendario.")
)

data class PersonajeTarjeta(val tittle: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Ejemplo1ComposerIDGS903Theme {
                Tarjeta(tarjetas)
            }

        }
    }
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        //ImagenHeroe()
        items(personajes){personaje ->

            Mypersonaje(personaje)
        }
    }
}

@Composable
fun Mypersonaje(personaje: PersonajeTarjeta) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Row(
            modifier = Modifier.padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ImagenHeroe()
            Personajes(personaje)
        }
    }

}

@Composable
fun Personaje(name:String, color: Color, style:TextStyle){
    Text(text = name)
}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Personaje(personaje.tittle,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium)

        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun ImagenHeroe(){
    Image(
        painter = painterResource(R.drawable.goku_normal),
        contentDescription = "Goku",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}


@Preview
@Composable
fun GreetingPreview(){
    Tarjeta(tarjetas)
}