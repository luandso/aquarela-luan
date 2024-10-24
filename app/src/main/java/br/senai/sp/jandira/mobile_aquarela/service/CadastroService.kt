package br.senai.sp.jandira.mobile_aquarela.service

import br.senai.sp.jandira.mobile_aquarela.model.Cadastro
import br.senai.sp.jandira.mobile_aquarela.model.Result
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface CadastroService {
    @Headers("Content-Type: application/json")
    @POST("/v1/aquarela/inserirUsuarios")
    fun inserirUsuarios(@Body cadastros : Cadastro): Call<Result>
}