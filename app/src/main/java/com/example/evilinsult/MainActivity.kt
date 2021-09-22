package com.example.evilinsult

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evilinsult.models.Insulto
import com.example.evilinsult.models.InsultoEntidad
import com.example.evilinsult.ui.theme.EvilInsultTheme
import com.example.evilinsult.viewmodel.InsultViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: InsultViewModel by viewModels()


    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvilInsultTheme {
                val navController = rememberNavController()
                val insultoDelViewModel = viewModel.insultoMutable

                Surface(color = Color.LightGray) {
                Navegacion(navController, viewModel)

                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun Navegacion(navController: NavHostController, viewModel: InsultViewModel) {
    val insultoDelViewModel = viewModel.insultoMutable
    NavHost(navController = navController, startDestination = "main_screen") {
        composable(route = "main_screen") {
            InsultScreen(
                insultoDelViewModel.component1().insult,
                viewModel,
                insultoDelViewModel.component1(), navController
            )
        }

        composable(route = "favoritos_screen") {
            FavoritsInsultScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun InsultScreen(
    insulto: String,
    viewModel: InsultViewModel,
    insultoClase: Insulto? = null,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Column(
        modifier.fillMaxSize().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center.also {
            Arrangement.spacedBy(20.dp)

        }

    ) {
        TarjetaEvil(insulto, viewModel)

        Spacer(modifier.size(10.dp))

        Button(onClick = {
            if (insultoClase != null) {
                viewModel.insert(insultoClase)
            }

        }) {
            Text("Save")
        }

        Spacer(modifier.size(50.dp))

        Button(
            onClick = {
                navController.navigate("favoritos_screen")
            }
        ) {
            Text("Favoritos")
        }
    }

}


@ExperimentalMaterialApi
@Composable
fun TarjetaEvil(
    insulto: String,
    viewModel: InsultViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        onClick = {
            viewModel.getInsult()
        }
    ) {
        Text(
            insulto,
            style = MaterialTheme.typography.h3,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center, modifier = modifier.padding(10.dp)
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun FavoritsInsultScreen(
    insulto: String? = null,
    viewModel: InsultViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val listadoInsultos = viewModel.listaInsulto.component1()

    Column(
        modifier.fillMaxSize().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center.also { Arrangement.spacedBy(20.dp) }

    ) {
        // TarjetaEvil(insulto, viewModel)
        LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            items(listadoInsultos.size) {
                val insultoActual = listadoInsultos[it]
                TarjetaEvil(insultoActual.insulto, viewModel)

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EvilInsultTheme {
        //InsultScreen("Nada")
    }
}