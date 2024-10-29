package br.senai.sp.jandira.mobile_aquarela

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mobile_aquarela.screens.LoginTela
import br.senai.sp.jandira.mobile_aquarela.screens.Preferencias
import br.senai.sp.jandira.mobile_aquarela.screens.TelaInicial
import br.senai.sp.jandira.mobile_aquarela.ui.theme.MobileaquarelaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileaquarelaTheme {
                val controleDeNavegacao = rememberNavController()
                NavHost(
                    navController = controleDeNavegacao,
                    startDestination = "Inicio"
                ){
                    composable(route = "Inicio"){ TelaInicial(controleDeNavegacao) }
                    composable(route = "Login"){ LoginTela(controleDeNavegacao) }
                    composable(route = "Preferencias") { Preferencias(controleDeNavegacao) }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginTelaPreview() {
    TelaInicial(controleDeNavegacao = NavHostController(LocalContext.current))
}