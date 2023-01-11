package com.nisaefendioglu.randomUselessFacts.service

import com.nisaefendioglu.randomUselessFacts.model.RandomUseless
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("random.json?language=en")
    fun getRandom(): Call<RandomUseless>
}
