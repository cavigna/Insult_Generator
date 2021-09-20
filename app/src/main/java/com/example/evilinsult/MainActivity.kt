package com.example.evilinsult

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
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
import com.example.evilinsult.ui.theme.EvilInsultTheme
import com.example.evilinsult.viewmodel.InsultViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : InsultViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvilInsultTheme {

                val insultoDelViewModel = viewModel.insultoMutable

                Surface(color = Color.Black) {

                    InsultScreen(insultoDelViewModel.component1().insult, viewModel)
                }
            }
        }
    }
}
@ExperimentalMaterialApi
@Composable
fun InsultScreen(
    insulto: String,
    viewModel: InsultViewModel,
    modifier: Modifier = Modifier
){

    Column(
        modifier.fillMaxSize().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center.also { Arrangement.spacedBy(20.dp) }

    ) {

        TarjetaEvil(insulto, viewModel)
    }

}
@ExperimentalMaterialApi
@Composable
fun TarjetaEvil(
    insulto: String,
    viewModel: InsultViewModel,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        onClick = {
            viewModel.getInsult()
        }
    ){
        Text(insulto,
            style =  MaterialTheme.typography.h3,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center

            ,modifier = modifier.padding(10.dp) )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EvilInsultTheme {
        //InsultScreen("Nada")
    }
}