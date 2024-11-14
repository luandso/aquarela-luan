package br.senai.sp.jandira.mobile_aquarela.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mobile_aquarela.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Compra(controleDeNavegacao : NavHostController){
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        OutlinedTextField(onValueChange = {}, value = "", colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), trailingIcon = { Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", tint = Color.White) }, label = { Text(text = "Pesquisar") })

        Scaffold(bottomBar = {
            BottomAppBar(actions = {
                NavigationBar(containerColor = Color.White){
                    NavigationBarItem(selected = true, onClick = {controleDeNavegacao.navigate("Cadastro Tela")}, icon = {})
                    NavigationBarItem(selected = true, onClick = {}, icon = {})
                    FloatingActionButton(onClick = {}) { }
                    NavigationBarItem(selected = true, onClick = {}, icon = {})
                    NavigationBarItem(selected = true, onClick = {}, icon = {})
                }/* IconButton(onClick = {}){}*/
//        IconButton(onClick = {}){ }
//        IconButton(onClick = {}){ }
//        IconButton(onClick = {}){ }
//        IconButton(onClick = {})
            },
            )
        }){Box(modifier = Modifier.fillMaxWidth().background(color = Color(0xff111111)).fillMaxHeight()){
            Row { Image(painter = painterResource(id = R.drawable.logo1), contentDescription = "")
                Column { Text(text = "")
                    Text(text = "")
                    Text(text = "")
                }
            }}
    }


    }}