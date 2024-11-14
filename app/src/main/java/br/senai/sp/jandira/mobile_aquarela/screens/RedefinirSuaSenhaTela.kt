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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mobile_aquarela.R

@Composable
fun RedefinirSuaSenhaTela() {
    var senha by remember{ mutableStateOf("") }
    var redefinida by remember{ mutableStateOf("")}
    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(150.dp)){
        Box(modifier = Modifier.fillMaxWidth().padding(4.dp)){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start){ Icon(imageVector = Icons.Default.ArrowBack, tint = Color.White, modifier = Modifier.height(30.dp).width(30.dp).background(Color(0xff3E7D8D), shape = CircleShape).padding(4.dp), contentDescription = "")
            }
        }
        Card(modifier = Modifier.height(350.dp).align(Alignment.CenterHorizontally), colors = CardDefaults.cardColors(containerColor = Color.Transparent)){
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally){
                Icon(painter = painterResource(id = R.drawable.logo1), modifier = Modifier.height(80.dp).width(80.dp), contentDescription = "", tint = Color.Unspecified)
                Text(text = " Redefinir a sua senha", fontSize = 18.sp, color = Color(0xff3E7D8D))
                Text(text = " Você poderá fazer login na sua conta", fontSize = 10.sp, color = Color(0xff5DA5B7))
                OutlinedTextField(onValueChange = {senha = it}, value = senha, colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), label = { Text(text = " Digite uma nova senha", fontSize = 12.sp) })
                OutlinedTextField(onValueChange = {redefinida = it}, value = redefinida, colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), label = { Text(text = "Confirme sua senha", fontSize = 12.sp) })
                Button(onClick = {/* TO DO*/ }, modifier = Modifier.height(40.dp).width(138.dp).background(brush = Brush.verticalGradient(colors = listOf(Color(0xff5DA5B7), Color(0xff3E7D8D))), shape = RoundedCornerShape(8.dp)), colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)){
                    Text(text = " Confirmar", fontSize = 10.sp) }
            }
        }
    }
}
@Composable
@Preview(showBackground = true)
fun RedefinirSuaSenhaTelaPreview(){
    RedefinirSuaSenhaTela()
    }