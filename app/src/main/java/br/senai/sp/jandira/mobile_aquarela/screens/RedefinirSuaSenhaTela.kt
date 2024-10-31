package br.senai.sp.jandira.mobile_aquarela.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mobile_aquarela.R

@Composable
fun RedefinirSuaSenhaTela() {
    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth()){
        Box(){
            Icon(imageVector = Icons.Default.ArrowBack, tint = Color.White, modifier = Modifier.height(30.dp).width(30.dp).background(Color(0xff3E7D8D), shape = CircleShape).padding(4.dp), contentDescription = "")
        }
        Card(modifier = Modifier.height(300.dp)){
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween){
                Icon(painter = painterResource(id = R.drawable.logo1), modifier = Modifier.height(80.dp).width(80.dp), contentDescription = "", tint = Color.Unspecified)
                Text(text = " Redefinir a sua senha", fontSize = 18.sp, color = Color(0xff3E7D8D))
                Text(text = " Você poderá fazer login na sua conta", fontSize = 10.sp, color = Color(0xff5DA5B7))
                OutlinedTextField(onValueChange = {}, value = " ", colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)))
                OutlinedTextField(onValueChange = {}, value = "", colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)))
                Button(onClick = {/* TO DO*/ }, modifier = Modifier.height(40.dp).width(138.dp).background(brush = Brush.verticalGradient(colors = listOf(Color(0xff5DA5B7), Color(0xff3E7D8D)))), colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)){
                    Text(text = " Confirmar") }
            }
        }
    }
}
@Composable
@Preview(showBackground = true)
fun RedefinirSuaSenhaTelaPreview(){
    RedefinirSuaSenhaTela()
    }