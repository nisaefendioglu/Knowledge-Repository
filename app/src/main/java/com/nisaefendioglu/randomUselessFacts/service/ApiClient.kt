package com.nisaefendioglu.randomUselessFacts.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://uselessfacts.jsph.pl/"
    fun create(apiInterface: Class<ApiInterface>): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(apiInterface)
    }
}
