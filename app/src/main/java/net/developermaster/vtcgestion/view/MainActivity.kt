package net.developermaster.vtcgestion.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.FirebaseApp

import com.google.firebase.firestore.FirebaseFirestore
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import net.developermaster.kotlincanivetesuico.utils.utilsGeral.mensagemToast
import net.developermaster.vtcgestion.R
import net.developermaster.vtcgestion.model.Model
import net.developermaster.vtcgestion.view.ui.theme.VtcGestionTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //todo tema do app
            VtcGestionTheme {

                //todo esqueleto do app
                Scaffold()

            }//todo fim do tema
        }//todo fim do setContent
    }//todo fim do onCreate

    @Composable
    fun Scaffold() {

        Scaffold(

            topBar = {

                //                TopBar()
            },

            bottomBar = {


                BottomBar()


            },

            floatingActionButton = {

                Fab()
            },

            snackbarHost = {

                TextoExemplo()

            },

//            containerColor = Color.Black,//todo cor preta do container do scaffold

        ) { pappdingInterno ->

            GoogleMapFundo()

            Home(Modifier.padding(pappdingInterno))//todo chamando a funcao Home com o padding interno
        }
    }

    @Composable
    fun Fab() {

        FloatingActionButton(onClick = {

            mensagemToast("Fab Clicado")

            //todo ação ao clicar no botão
            Intent(this, ActivityAdicionar::class.java).also {
                startActivity(it)
            }

        }) {

            Icon(
                imageVector = Icons.Filled.Add, contentDescription = "Localized description"
            )
        }
    }

    @Composable
    fun BottomBar() {

        BottomAppBar(
            containerColor = Color.Gray,

            ) {

            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {

                        Toast
                            .makeText(this@MainActivity, "Home Clicado", Toast.LENGTH_SHORT)
                            .show()

                    },//todo clique
            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .padding(start = 130.dp)
                    .clickable {

                        Toast
                            .makeText(this@MainActivity, "Favorite Clicado", Toast.LENGTH_SHORT)
                            .show()

                    },//todo clique
            )
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .padding(start = 130.dp)
                    .clickable {

                        Toast
                            .makeText(this@MainActivity, "AddCircle Clicado", Toast.LENGTH_SHORT)
                            .show()

                    },//todo clique
            )
        }
    }

    @Composable
    fun Home(modifier: Modifier) {

        Column(
            modifier = modifier //todo modificador
                .fillMaxWidth()//todo largura

        ) {

            Row {
                ImagemPerfil()
            }//Row imagem perfil

            Row {
                TextoPerfil()
            }//Row nome perfil

            Espaco()

            LazyColumn {
                //todo lista
                item {

                    Salvar()
//                    SalvarNoFirestore()

                }
            }//LazyColumn Caixa de texto
        }
    }

    @Composable
    fun Salvar() {

        var ganacia
        by remember { mutableStateOf("") }

        val model = Model(ganacia = ganacia)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(value = ganacia,
                onValueChange = { ganacia = it },
                label = { Text("Enter some text") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(

                onClick = {

                    val data = hashMapOf(
                        "text" to ganacia
                    )

                    FirebaseFirestore.getInstance().collection("VtcGestion").document().set(model)
                        .addOnSuccessListener { sucesso ->
                            mensagemToast("Salvo com sucesso")
                        }.addOnFailureListener { erro ->
                            mensagemToast("Salvo com sucesso ${erro.message}")//
                        }
                },

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("Save to Firestore")
            }
        }
    }

    @Composable
    fun Espaco() {
        Spacer(modifier = Modifier.height(16.dp))
    }

    @Composable
    fun ImagemPerfil() {

        Image(modifier = Modifier
            .clickable {
                mensagemToast("Clicado na imagem")
            }
            .size(60.dp) //todo tamanho da imagem
            .clip(CircleShape)
            .border(2.dp, Color.Black, CircleShape)
            .background(Color.White),

            painter = painterResource(R.drawable.perfil_01),
            contentDescription = null, //todo conteudo da imagem
            contentScale = ContentScale.Crop)
    }

    @Composable
    fun TextoPerfil() {

        Text(modifier = Modifier
            .clickable {
                mensagemToast("Clicado no nome")
            }
            .background(Color.White)
            .padding(start = 8.dp, top = 16.dp),

            text = "nome", fontSize = 12.sp,//todo tamanho da fonte
            fontFamily = FontFamily.SansSerif,//todo tipo de fonte
            color = Color.Black//todo cor preta
        )
    }

    @Composable
    fun TextoExemplo() {

        Text(
            text = "Nome",//todo texto
            color = Color.Red,//todo cor vermelha
            fontSize = 30.sp,//todo tamanho da fonte
            fontFamily = FontFamily.SansSerif,//todo tipo de fonte
        )
    }

    @Composable
    fun GoogleMapFundo() {

        GoogleMap(
            modifier = Modifier.fillMaxSize(),

            //todo propriedades do mapa
            properties = MapProperties(

                //todo previsualizacao de edificios 3D
                isBuildingEnabled = true,

                )
        )/*


                        //todo habilitar a localizacao
        //                isMyLocationEnabled = true,

                        //todo habilitar a rota
                        isTrafficEnabled = true,

                        //todo habilitar a direcao
        //                isIndoorEnabled = true,


                        )
                )*/
    }

    @Composable
    fun CaixaDeTextoTextFild() {

        var texto by remember { mutableStateOf("") }

        TextField(

            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(all = 8.dp),

            value = texto,//todo valor do texto

            onValueChange = { textoDigitado ->

                texto = textoDigitado//todo valor do texto digitado na variavel texto

                mensagemToast(texto)
            },

            placeholder = {

                Text(text = "Caixa de texto") //todo texto do label

            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = null,
                    modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue
                )
            },

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier.width(50.dp),//todo largura
                    tint = Color.Blue
                )
            })
    }

    @Composable
    fun CaixaDeTextoOutLineTextField() {

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

                Text(text = "Caixa de texto") //todo texto do label
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

    @Preview(showBackground = true)

    @Composable
    fun PreviewHome() {
        VtcGestionTheme {
            Home(Modifier.fillMaxSize())
        }
    }
}



