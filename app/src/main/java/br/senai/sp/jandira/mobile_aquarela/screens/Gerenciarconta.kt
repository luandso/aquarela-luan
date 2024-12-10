package br.senai.sp.jandira.mobile_aquarela.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mobile_aquarela.R

@Composable
fun Gerenciarconta(){
    var emailState by remember {
        mutableStateOf("")
    }
    var senhaState by remember {
        mutableStateOf("")
    }
    var cpfState by remember {
        mutableStateOf("")
    }
    var dataDeNascimentoUsuarioState by remember {
        mutableStateOf("")
    }
    var telefoneUsuarioState by remember {
        mutableStateOf("")
    }
    var confirmarSenha by remember{
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(4.dp), verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally){
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(120.dp)){
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", modifier = Modifier.width(16.dp).height(16.dp).background(Color(0xff204149), shape = CircleShape).padding(4.dp), tint = Color.White)
            Text(text = "Gerenciar conta", fontSize = 16.sp, color = Color(0xff04242C))
        }
        Column {Text(text = "Email", color = Color(0xff04242C))
            OutlinedTextField(onValueChange = {emailState = it}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)))  }
        Column { Text(text = "CPF", color = Color(0xff04242C))
            OutlinedTextField(onValueChange = {cpfState = it}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4))) }
        Column { Text(text = "Data de nascimento", color = Color(0xff04242C))
            OutlinedTextField(onValueChange = {dataDeNascimentoUsuarioState = it}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4))) }
        Column { Text(text = "Telefone", color = Color(0xff04242C))
            OutlinedTextField(onValueChange = {telefoneUsuarioState = it}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4))) }
        Column { Text(text = "Redefinir senha", color = Color(0xff04242C))
            OutlinedTextField(onValueChange = {senhaState = it}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4))) }
        Column { Text(text = "Confirme a senha", color = Color(0xff04242C))
            OutlinedTextField(onValueChange = {confirmarSenha = it}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4))) }
        Button(onClick = {}, modifier = Modifier.height(38.dp).width(252.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xff204149)), shape = RoundedCornerShape(4.dp)) { Text(text = "Salvar") }
    }
}
@Preview(showSystemUi = true)
@Composable
fun Gerenciarcontapreview(){
    Gerenciarconta()
}