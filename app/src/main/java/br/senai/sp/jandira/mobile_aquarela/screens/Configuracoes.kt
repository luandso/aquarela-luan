package br.senai.sp.jandira.mobile_aquarela.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.mobile_aquarela.R

@Composable
fun Configuracoes(){
Column(modifier = Modifier.fillMaxHeight().fillMaxWidth()){
    Row(modifier = Modifier.fillMaxWidth()){
        Image(imageVector = Icons.Default.ArrowBack, contentDescription = "", modifier = Modifier.padding(4.dp).background(color = Color(0xff204149), shape = CircleShape).width(16.dp).height(16.dp))
        Text(text = "Configurações")
    }
    Row(modifier = Modifier.fillMaxWidth()){ Image(imageVector = Icons.Default.Person, contentDescription = "")
    Column{ Text(text = "Perfil")
    Text(text = "Editar Perfil")
    }
    Row{ Image(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "") }}
    Row(modifier = Modifier.fillMaxWidth()){ Text(text = "Gerenciar Conta")
    Image(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
    }
    Row(modifier = Modifier.fillMaxWidth()){ Text(text = "Endereços")
    Image(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
    }
    Row(modifier = Modifier.fillMaxWidth()){ Text(text = "Preferências")
    Image(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
    }
    Row(modifier = Modifier.fillMaxWidth()){ Text(text = "Ajustar Feed Inicial")
    Image(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
    }
    Box {}
    Box {}
}}