package br.senai.sp.jandira.mobile_aquarela.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Vendas(){
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        OutlinedTextField(onValueChange = {}, value = "", colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), trailingIcon = { Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", tint = Color.White) }, label = { Text(text = "Pesquisar") })
        Box(modifier = Modifier.fillMaxWidth())
        Scaffold(bottomBar = {
            BottomAppBar(actions = {
                NavigationBar(containerColor = Color.White){
                    NavigationBarItem(selected = true, onClick = {}, icon = {})
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
        }){}
    }
}