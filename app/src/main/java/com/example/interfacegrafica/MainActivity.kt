package com.example.interfacegrafica

import android.graphics.Paint.Align
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interfacegrafica.ui.theme.InterfaceGraficaTheme


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainActivity : ComponentActivity() {
    private lateinit var minhaViewModelQueEuCrieiAgoraPouco: MinhaViewModelBemSimples


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        minhaViewModelQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhaViewModelBemSimples::class.java)

        setContent {
            InterfaceGraficaTheme {
                MainScreen(minhaViewModelQueEuCrieiAgoraPouco)
            }
        }
    }
}

/*
@Composable
fun MainScreen(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFFd3d3d3))
                .border(
                    width = 5.dp,
                    brush = Brush.horizontalGradient(listOf(Color.Red, Color.Blue)),
                    shape = RectangleShape
                )
                .padding(all = 20.dp)
        ) {
            //MinhaSaudaao(nome = "World\n")

            MinhaSaudaao(
                "World",
                "Sábado\n",
                modificador = Modifier
                    .border(
                        border = BorderStroke(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color.Blue, Color.Blue)
                            )
                        ),
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(all = 20.dp)

            )

            //MinhaSaudaao(dia = "Sábado", nome = "World\n")

            Greeting("João")
        }
}
*/


@Composable
fun MainScreen(umaViewModel: MinhaViewModelBemSimples){
    var contadorNaView by remember { mutableStateOf(0) }
    //var contador: Int = 0

    val contadorProvenienteDaMinhaModelView by umaViewModel.contadorDaViewPublico.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row() {
            Button(
                onClick = {
                    contadorNaView = contadorNaView + 1 // coisa de estudante
                    umaViewModel.incrementaContador() //coisa de prtof
                    Log.i("###### NOSSO_LOG", "Valor do contador: $contadorProvenienteDaMinhaModelView")
                }
            ) {
                Text(text = "Incrementa Contador")
            }
            Button(
                onClick = {
                    contadorNaView = contadorNaView - 1// coisa de estudante
                    umaViewModel.desincrementaContador() //coisa de prtof
                    Log.i("###### NOSSO_LOG", "Valor do contador: $contadorProvenienteDaMinhaModelView")
                }
            ) {
                Text(text = "Diminui Contador")
            }
        }
       Text("Valor do contador controlado pela View: $contadorNaView \n" +
               "Valor do Contador controlado pela ViewModel: $contadorProvenienteDaMinhaModelView")

        Spacer(modifier = Modifier.height(100.dp))
        Column {
            Text("João Enrique Barbosa Santos Alves")
            Spacer(modifier = Modifier.width(100.dp))
            Text("RM: 22316")
        }
    }

    Log.i("###### NOSSO_LOG", "Valor do contador: $contadorProvenienteDaMinhaModelView")
}



@Composable
fun MinhaSaudaao(
    nome: String?,
    dia: String = "dia 20/05/2023",
    modificador: Modifier
){
    Text(
        text = "Hello $nome \nHoje é $dia",
        color = Color(0xFF002060),
        modifier = modificador
    )

}


@Composable
fun Greeting(name: String, modificador: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modificador,
        color = Color(0xFF002060)
    )
}

@Preview(showBackground = true)
@Composable
fun MinhaPreview() {
    InterfaceGraficaTheme {
        //MainScreen()
    }
}