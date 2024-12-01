package br.senai.sp.jandira.mobile_aquarela.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mobile_aquarela.R

@Composable
fun Gerenciarconta(){
    Column {
        Row {
            Icon(painter = painterResource(id = R.drawable.logo1), contentDescription = "")
            Text(text = "")
        }
        Text(text = "Email")
        OutlinedTextField(onValueChange = {}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)))
        Text(text = "CPF")
        OutlinedTextField(onValueChange = {}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)))
        Text(text = "Data de nascimento")
        OutlinedTextField(onValueChange = {}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)))
        Text(text = "Telefone")
        OutlinedTextField(onValueChange = {}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)))
        Text(text = "Redefinir senha")
        OutlinedTextField(onValueChange = {}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)))
        Text(text = "Confirme a senha")
        OutlinedTextField(onValueChange = {}, value = "", colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)))
        Box {  }
    }
}