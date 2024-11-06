package net.developermaster.vtcgestion.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.developermaster.vtcgestion.view.ui.ui.theme.VtcGestionTheme

class ActivityAdicionar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VtcGestionTheme {

                Home(Modifier.fillMaxSize()
                    /*.background(Color.Blue)*/)//todo chamando a funcao Home com o padding interno
            }
        }
    }

    @Composable
    fun Home(modifier: Modifier) {

        Column(
            modifier = modifier //todo modificador
                .fillMaxWidth()//todo largura

        ) {

            Column {

                Spacer(modifier = Modifier.height(30.dp))

                TextoCabecalhoActivityAdicionar()

                Data()

                Espaco()

                Ganancia()

                Espaco()

                HorasTrabalhadas()

                Espaco()

                EfectivoRecorrido()

                Espaco()

                EfectivoIngresado()

                Espaco()

                Propina()

                ButtonOkActivityAdicionar()

            }//Column Caixa de texto
        }
    }



    @Composable
    fun TextoCabecalhoActivityAdicionar() {

        Text(modifier = Modifier.padding(start = 100.dp),

            text = "Adicione sus Actividads",//todo texto
            color = Color.Black,//todo cor preta
        )
    }
     @Composable
    fun Data() {

         var texto by remember { mutableStateOf("") }

         OutlinedTextField( //todo caixa de texto com borda

             modifier = Modifier
                 .background(Color.White)
                 .fillMaxWidth()
                 .padding(all = 8.dp),

             value = texto,//todo valor do texto

             onValueChange = { textoDigitado ->

                 texto = textoDigitado//todo valor do texto digitado na variavel texto

                 mensagemToast(texto)
             },

             label = {

                 Text(text = "Fecha") //todo texto do label
             },

             leadingIcon = {
                 Icon(
                     imageVector = Icons.Default.ThumbUp,//todo icone
                     contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                     tint = Color.Blue//todo cor azul da borda
                 )
             },

             trailingIcon = {
                 Icon(
                     imageVector = Icons.Default.Favorite,//todo icone
                     contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                     tint = Color.Blue//todo cor azul da borda
                 )
             })
     }

    @Composable
    private fun Ganancia() {

        var texto by remember { mutableStateOf("") }

        OutlinedTextField( //todo caixa de texto com borda

            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(all = 8.dp),

            value = texto,//todo valor do texto

            onValueChange = { textoDigitado ->

                texto = textoDigitado//todo valor do texto digitado na variavel texto

                mensagemToast(texto)
            },

            label = {

                Text(text = "Ganancia") //todo texto do label
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ThumbUp,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            },

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Favorite,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            })
    }

    @Composable
    private fun HorasTrabalhadas() {

        var texto by remember { mutableStateOf("") }

        OutlinedTextField( //todo caixa de texto com borda

            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(all = 8.dp),

            value = texto,//todo valor do texto

            onValueChange = { textoDigitado ->

                texto = textoDigitado//todo valor do texto digitado na variavel texto

                mensagemToast(texto)
            },

            label = {

                Text(text = "Horas trabajadas") //todo texto do label
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ThumbUp,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            },

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Favorite,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            })
    }

    @Composable
    private fun EfectivoRecorrido() {

        var texto by remember { mutableStateOf("") }

        OutlinedTextField( //todo caixa de texto com borda

            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(all = 8.dp),

            value = texto,//todo valor do texto

            onValueChange = { textoDigitado ->

                texto = textoDigitado//todo valor do texto digitado na variavel texto

                mensagemToast(texto)
            },

            label = {

                Text(text = "Efectivo recorrido") //todo texto do label
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ThumbUp,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            },

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Favorite,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            })
    }

    @Composable
    private fun EfectivoIngresado() {

        var texto by remember { mutableStateOf("") }

        OutlinedTextField( //todo caixa de texto com borda

            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(all = 8.dp),

            value = texto,//todo valor do texto

            onValueChange = { textoDigitado ->

                texto = textoDigitado//todo valor do texto digitado na variavel texto

                mensagemToast(texto)
            },

            label = {

                Text(text = "Efectivo ingresado") //todo texto do label
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ThumbUp,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            },

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Favorite,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            })
    }

    @Composable
    private fun Propina() {

        var texto by remember { mutableStateOf("") }

        OutlinedTextField( //todo caixa de texto com borda

            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(all = 8.dp),

            value = texto,//todo valor do texto

            onValueChange = { textoDigitado ->

                texto = textoDigitado//todo valor do texto digitado na variavel texto

                mensagemToast(texto)
            },

            label = {

                Text(text = "Propinas") //todo texto do label
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ThumbUp,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            },

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Favorite,//todo icone
                    contentDescription = null, modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue//todo cor azul da borda
                )
            })
    }

    @Composable
    fun ButtonOkActivityAdicionar() {

        Button(modifier = Modifier.padding(start = 150.dp), onClick = {

            mensagemToast("Ok")

        }) {

            Text(text = "Ok")

            Spacer(modifier = Modifier.width(10.dp))

            Icon(

                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Color.Red
            )
        }


    }

    @Composable
    fun Espaco() {
        Spacer(modifier = Modifier.height(16.dp))
    }

    @Preview(showBackground = true)

    @Composable
    fun GreetingPreview() {
        VtcGestionTheme {
            Home(Modifier.fillMaxSize())
        }
    }

    fun mensagemToast(messagem: String) {
        Toast.makeText(this, messagem, Toast.LENGTH_SHORT).show()
    }
}