package br.senai.sp.jandira.mobile_aquarela.service

import br.senai.sp.jandira.mobile_aquarela.model.Login
import br.senai.sp.jandira.mobile_aquarela.model.ResultUsuarioIncompleto
import br.senai.sp.jandira.mobile_aquarela.model.UsuarioCompleto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @Headers("Content-Type: application/json")
    @POST("user")
    fun inserirUsuarios(@Body cadastros : UsuarioCompleto): Call<ResultUsuarioIncompleto>

    @Headers("Content-Type: application/json")
    @POST("authentication/user/email")
    fun login(@Body login: Login): Call<ResultUsuarioIncompleto>
}