package br.senai.sp.jandira.mobile_aquarela.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mobile_aquarela.R
import br.senai.sp.jandira.mobile_aquarela.model.Login
import br.senai.sp.jandira.mobile_aquarela.model.ResultUsuarioIncompleto
import br.senai.sp.jandira.mobile_aquarela.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTela(controleDeNavegacao: NavHostController)
{
    var emailLoginState = remember {
        mutableStateOf("")
    }
    var senhaLoginState = remember {
        mutableStateOf("")
    }

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xffE2E8EB)) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.imagemdefundo),
                contentDescription = "Imagem de fundo",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color.White,
                modifier = Modifier
                    .background(color = Color(0xff3E7D8D), shape = CircleShape)
                    .padding(6.dp)
                    .align(Alignment.TopStart)
                    .clickable { controleDeNavegacao.navigate("Inicio") }
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(30.dp) // Adjusted spacing
            ) {
//                var emailState by remember { mutableStateOf("") }
//                var senhaState by remember { mutableStateOf("") }
                var rememberMeState by remember { mutableStateOf(false) }
                var passwordVisible by remember { mutableStateOf(false) }

                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Bem-Vindo!",
                        fontSize = 32.sp,
                        color = Color(0xff3E7D8D),
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "Faça login na sua conta",
                        fontSize = 14.sp,
                        color = Color(0xff5DA5B7)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        value = emailLoginState.value,
                        onValueChange = { emailLoginState.value = it },
                        label = { Text(text = "Email") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xffB8CED4),
                            unfocusedBorderColor = Color.Transparent,
                            focusedContainerColor = Color(0xffB8CED4)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        value = senhaLoginState.value,
                        onValueChange = { senhaLoginState.value = it },
                        label = { Text(text = "Senha") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = "Senha")
                        },
                        trailingIcon = {
                            val image = if (passwordVisible)
                                Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff

                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                            }
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xffB8CED4),
                            unfocusedBorderColor = Color.Transparent,
                            focusedContainerColor = Color(0xffB8CED4)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )

                    // Lembre-se de mim
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .clickable { rememberMeState = !rememberMeState }
                                .padding(horizontal = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = rememberMeState,
                                onCheckedChange = { rememberMeState = it }
                            )
                            Text(
                                text = "Lembre-se de mim",
                                color = Color(0xff5DA5B7),
                                fontSize = 14.sp
                            )
                        }
                        Text(
                            text = "Esqueci minha senha",
                            color = Color(0xff3E7D8D),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(horizontal = 30.dp)
                        )
                    }
                }

                Button(
                    onClick = {
                        val login = Login(
                            email = emailLoginState.value,
                            senha = senhaLoginState.value
                        )

                        if(login.senha != "" && login.email != ""){
                            RetrofitFactory().getCadastroService().login(login).enqueue(object : retrofit2.Callback<ResultUsuarioIncompleto> {
                                override fun onResponse(
                                    p0: Call<ResultUsuarioIncompleto>,
                                    p1: Response<ResultUsuarioIncompleto>
                                ) {
                                    Log.i("RESPONSE:", p1.toString())
                                }

                                override fun onFailure(
                                    p0: Call<ResultUsuarioIncompleto>,
                                    p1: Throwable
                                ) {
                                    TODO("Not yet implemented")
                                }
                            })
                        }

                    },
                    modifier = Modifier
                        .width(320.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(0xFF3E7D8D), Color(0xFF5DA5B7))
                                )
                            )
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 25.sp,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    HorizontalDivider(
                        modifier = Modifier
                            .height(1.dp)
                            .width(120.dp),
                        color = Color.Gray
                    )
                    Text(
                        text = "ou",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = Color(0xff3E7D8D),
                        fontWeight = FontWeight.Bold
                    )
                    HorizontalDivider(
                        modifier = Modifier
                            .height(1.dp)
                            .width(120.dp),
                        color = Color.Gray
                    )
                }

                Row(
                    modifier = Modifier
                        .background(color = Color(0xff3E7D8D), shape = RoundedCornerShape(20.dp))
                        .width(270.dp)
                        .height(35.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.GMobiledata, contentDescription = "Google", tint = Color.White)
                    Text(text = "Cadastre com o Google", color = Color.White)
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun LoginTelaPreview() {
    LoginTela(controleDeNavegacao = NavHostController(LocalContext.current))
}