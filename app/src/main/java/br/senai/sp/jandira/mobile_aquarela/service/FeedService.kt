package br.senai.sp.jandira.mobile_aquarela.service

import br.senai.sp.jandira.mobile_aquarela.model.FeedPost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FeedService {

    @GET("/v1/aquarela/feed/{id}")
    fun getFeedPosts(@Path("id") id: Int): Call<List<FeedPost>>
}