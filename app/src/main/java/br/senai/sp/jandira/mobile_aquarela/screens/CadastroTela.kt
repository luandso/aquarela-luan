package br.senai.sp.jandira.mobile_aquarela.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.GMobiledata
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mobile_aquarela.R
import br.senai.sp.jandira.mobile_aquarela.model.Cadastro
import br.senai.sp.jandira.mobile_aquarela.model.Result
import br.senai.sp.jandira.mobile_aquarela.model.ResultUsuarioIncompleto
import br.senai.sp.jandira.mobile_aquarela.model.UsuarioCompleto
import br.senai.sp.jandira.mobile_aquarela.model.UsuarioIncompleto
import br.senai.sp.jandira.mobile_aquarela.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CadastroTela(controleDeNavegacao : NavHostController){
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xffE2E8EB)){
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
            var nomeCompletoState by remember{
                mutableStateOf("")}
            var apelidoState by remember {
                mutableStateOf("")
            }
            var emailState by remember {
                mutableStateOf("")
            }
            var senhaState by remember {
                mutableStateOf("")}
            var cpfState by remember {
                mutableStateOf("")
            }
            var dataDeNascimentoUsuarioState by remember {
                mutableStateOf("")
            }
            var telefoneUsuarioState by remember {
                mutableStateOf("")
            }
            var estaVazioState by remember {
                mutableStateOf("Campo obrigatório")}
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "icon",
                    tint = Color.White,
                    modifier = Modifier
                        .background(color = Color(0xff3E7D8D), shape = CircleShape)
                        .padding(4.dp).clickable {controleDeNavegacao.navigate("Inicio")}
                )
            }
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
Text(text = "Cadastre-se", fontSize = 32.sp, color = Color(0xff3E7D8D), fontWeight = FontWeight.Medium)
                Text(text = "Crie uma nova conta", fontSize = 14.sp, color = Color(0xff5DA5B7))
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(500.dp), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly){
                OutlinedTextField(value = nomeCompletoState, onValueChange = {nomeCompletoState = it}, colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), leadingIcon = { Icon(imageVector = Icons.Default.PermIdentity, contentDescription = " ", tint = Color(0xff3E7D8D)) }, label = { Text(modifier = Modifier.padding(start = 10.dp), fontFamily = FontFamily.Default, fontSize = 14.sp, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Light, text = "Nome completo")}, singleLine = true )
                OutlinedTextField(value = apelidoState, onValueChange = {apelidoState = it}, colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), label = {Text(text = "Apelido")}, leadingIcon = {
                    Image(painter = painterResource(id = R.drawable.icon), contentDescription = " ", modifier = Modifier
                        .height(50.dp)
                        .width(30.dp))}, singleLine = true)
                OutlinedTextField(value = emailState, onValueChange = {emailState = it}, colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), label = {Text(text = "Email")}, leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = " ", tint = Color(0xff3E7D8D))}, singleLine = true)
                OutlinedTextField(value = senhaState, onValueChange = {senhaState = it}, colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), label = {Text(text = "Senha")}, leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = " ", tint = Color(0xff3E7D8D))}, singleLine = true)
                OutlinedTextField(value = cpfState, onValueChange = {cpfState = it}, colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), label = {Text(text = "Cpf")}, leadingIcon = {
                    Image(painter = painterResource(id = R.drawable.icon1), contentDescription = " ", modifier = Modifier
                        .height(50.dp)
                        .width(30.dp))}, singleLine = true)
                OutlinedTextField(value = dataDeNascimentoUsuarioState, onValueChange = {dataDeNascimentoUsuarioState = it}, colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), label = {Text(text = "Data de nascimento")}, leadingIcon = {
                    Icon(imageVector = Icons.Default.Cake, contentDescription = "", tint = Color(0xff3E7D8D))}, singleLine = true)
                OutlinedTextField(value = telefoneUsuarioState, onValueChange = {telefoneUsuarioState = it}, colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xffB8CED4), unfocusedBorderColor = Color.Transparent, focusedContainerColor = Color(0xffB8CED4)), label = {Text(text = "Telefone")}, leadingIcon = {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = " ", tint = Color(0xff3E7D8D))}, singleLine = true)
            }
            Button(onClick = {
                val callUsuarios = RetrofitFactory().getCadastroService().inserirUsuarios(
                    cadastros = UsuarioCompleto(
                        nome = nomeCompletoState,
                        nome_usuario = apelidoState,
                        foto_usuario = null,
                        descricao = null,
                        email = emailState,
                        senha = senhaState,
                        cpf = cpfState,
                        data_nascimento = dataDeNascimentoUsuarioState,
                        telefone = telefoneUsuarioState,
                        disponibilidade = null,
                        user_stats = true
                    )
                )
                callUsuarios.enqueue(object : Callback<ResultUsuarioIncompleto>{
                    override fun onResponse(p0: Call<ResultUsuarioIncompleto>, p1: Response<ResultUsuarioIncompleto>) {
                        Log.i("foi", p1.body().toString())
                        controleDeNavegacao.navigate("Preferencias")
                    }

                    override fun onFailure(p0: Call<ResultUsuarioIncompleto>, p1: Throwable) {
                        Log.i("falhou", p1.toString())
                    }
                })},modifier = Modifier
                    .width(270.dp)
                    .height(50.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xff5DA5B7),
                                Color(0xff3E7D8D)
                            )
                        )
                    ),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
Text(text = "Cadastrar", fontSize = 20.sp)
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(270.dp)){
                Row(modifier = Modifier.background(color = Color(0xff3E7D8D)).height(1.dp).width(110.dp)){}
                Text(text = "ou")
                Row(modifier = Modifier.background(color = Color(0xff3E7D8D)).height(1.dp).width(110.dp)){}
                }
            Row(modifier = Modifier
                .background(
                    color = Color(0xff3E7D8D), shape = RoundedCornerShape(20.dp)
                )
                .width(270.dp)
                .height(35.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
Icon(imageVector = Icons.Default.GMobiledata, contentDescription = " ", tint = Color.White)
                Text(text = "Cadastre com o google", color = Color.White)
            }
        }
    }
}
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun CadastroTelaPreview(){
    //CadastroTela()
}