package br.senai.sp.jandira.mobile_aquarela.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val BASE_URL = "https://aquarela-nt8n.onrender.com"
    private val retrofitFactory = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    fun pegarCadastroService(): CadastroService{
        return retrofitFactory.create(CadastroService::class.java)
    }
}